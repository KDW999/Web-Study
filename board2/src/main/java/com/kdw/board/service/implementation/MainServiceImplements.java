package com.kdw.board.service.implementation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kdw.board.service.MainService;

@Service
public class MainServiceImplements implements MainService {
    
    //? 스케쥴 작업이 끝나는 시간 기준으로 실행
    // @Scheduled(fixedDelay = 1000)
    // public void scheduleFixedDelay(){
    //     System.out.println("고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    //? 스케쥴 작업이 시작하는 시간 기준으로 실행
    // @Scheduled(fixedRate = 1000)
    // public void scheduleFixedRate(){
    //     System.out.println("시작 고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    //? 시간을 지정해서 특정 시간마다 데이터 실행
    // @Scheduled(cron = "34 * * * * ?")
    // public void scheduleCronJob(){
    //     // System.out.println("Cron Job으로 시간 지정 작업 : " + System.currentTimeMillis() / 1000);
    //     try {
    //       crawlling();   
    //     } catch (Exception exception) {
    //         exception.printStackTrace();
    //     }
    // }

    //? 자바로 크롤링
    public void crawlling() throws Exception {

        Document doc = Jsoup.connect("https://www.naver.com/").get();

        // System.out.println(doc.html());

        // try {
        // Elements elements = doc.select(".h2");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        Elements elements = doc.select("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li > a");
        System.out.println(elements.size());

        for (Element element: elements) {
            System.out.println(element.absUrl("href"));
        }
    }
}
