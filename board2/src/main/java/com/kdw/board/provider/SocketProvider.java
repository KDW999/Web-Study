package com.kdw.board.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class SocketGroup {
    private String room;
    private WebSocketSession webSocketSession;
    
}

@Component
public class SocketProvider extends TextWebSocketHandler{
    
    private List<SocketGroup> sessionList = new ArrayList<>();
    
    //? Socket 연결
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("Socket Connected!!");
        System.out.println(webSocketSession.getHandshakeHeaders().getFirst("room"));
        
        String room = webSocketSession.getHandshakeHeaders().getFirst("room");
        sessionList.add(new SocketGroup(room, webSocketSession));
           
    }

    //? Socket 데이터
    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws Exception {
        String messagePayload = textMessage.getPayload();
        System.out.println(messagePayload);

        String room = webSocketSession.getHandshakeHeaders().getFirst("room");
        for(SocketGroup socketGroup : sessionList) {
            if(socketGroup.getRoom().equals(room)) {
                socketGroup.getWebSocketSession().sendMessage(textMessage);
            }
        }
    }

    //? Socket 연결 끊기
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus){
        System.out.println("Socket Closed!");
        System.out.println(webSocketSession.toString());
        System.out.println(closeStatus.toString());

        for(SocketGroup socketGroup : sessionList){
            if(socketGroup.getWebSocketSession().equals(webSocketSession)){
                sessionList.remove(socketGroup);
            }
        }
    }
}
