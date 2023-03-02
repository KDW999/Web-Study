package index;

import java.util.*;
import database.DAO.BoardDAO;
import database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.InsertBoardDTO;
import dto.UpdateBoardDTO;
import service.BoardService;

public class MainApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();

		BoardService boardService = new BoardService();

		/////////////////////////////////////////////////
		// 사용자로부터 입력 받음
		if (path.equals("POST /board")) {
			System.out.println("boardTitle : ");
			String boardTitle = sc.nextLine();
			System.out.println("boardContent : ");
			String boardContent = sc.nextLine();
			System.out.println("boardWriter : ");
			Integer boardWriter = sc.nextInt();
			/////////////////////////////////////////////////

			// 입력 검증
			if (boardTitle.isBlank() || boardContent.isBlank() || boardWriter < 0)
				System.out.println("Invalid Input");
			/////////////////////////////////////////////////
			// Service Layer 전송할 DTO 생성
			InsertBoardDTO insertBoardDto = new InsertBoardDTO(boardTitle, boardContent, boardWriter);

			/////////////////////////////////////////////////
			// 실제 비즈니스 로직 실행하기 위해 Service의 메서드 호출
			int result = boardService.postBoard(insertBoardDto);

			/////////////////////////////////////////////////
			// 비즈니스 로직 결과에 따라 결과를 출력
			
			if (result == 1)
				System.out.println("Insert Success");
			else
				System.out.println("Insert Failed");
		} else if (path.equals("GET /boardList")) {
			
			/////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드 호출
			List<BoardEntity> boardList = boardService.getBoardList();
			
			/////////////////////////////////////////////////
			// 비즈니스 로직 결과를 출력
			for (BoardEntity board : boardList)
				System.out.println(board.toString());
		} else if (path.equals("PATCH /board")) {

			/////////////////////////////////////////////////
			// 사용자로부터 입력 받음
			System.out.println("id : ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.println("boardTitle : ");
			String boardTitle = sc.nextLine();
			System.out.println("boardContent : ");
			String boardContent = sc.nextLine();

			/////////////////////////////////////////////////
			// 입력 검증
			if (boardTitle.isBlank() || boardContent.isBlank() || id < 0)
				System.out.println("Invalid Input");

			/////////////////////////////////////////////////
			// Service Layer 전송할 DTO 생성
			UpdateBoardDTO updateBoardDto = new UpdateBoardDTO(id, boardTitle, boardContent);

			/////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드 호출
			int result = boardService.patchBoard(updateBoardDto);

			/////////////////////////////////////////////////
			// 비즈니스 로직 결과에 따라 결과 출력
			if (result == 1)
				System.out.println("Update Success");
			else if (result == -1)
				System.out.println("Does Not Exist Board");
			else
				System.out.println("Update Failed");
		} else if (path.equals("DELETE /board")) {

			/////////////////////////////////////////////////
			// 사용자로부터 입력 받음
			System.out.println("id : ");
			Integer id = sc.nextInt();

			/////////////////////////////////////////////////
			// 입력 검증
			if (id < 0)
				System.out.println("Invalid Input");

			/////////////////////////////////////////////////
			// Service Layer로 전송할 DTO 생성
			DeleteBoardDTO deleteBoardDto = new DeleteBoardDTO(id);

			/////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드 호출
			int result = boardService.deleteBoard(deleteBoardDto);

			/////////////////////////////////////////////////
			// 비즈니스 로직 결과에 따라 결과 출력
			if (result == 1)
				System.out.println("Delete Success");
			else
				System.out.println("Delete Failed");
		} else {
			System.out.println("404 Not Found");
		}

	}
}
