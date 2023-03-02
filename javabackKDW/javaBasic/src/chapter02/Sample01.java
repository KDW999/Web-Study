package chapter02;

import java.util.Scanner;

// 게시물 작성
// 게시물 목록
// 게시물 상세 보기
// 게시물 수정
class Board{
	// 게시물 구분자, 순서
	int id;
	// 제목
	String title;
	// 작성자
	String writer;
    // 작성 날짜 및 시간
	String writeDate;
	// 내용
	String contents;
	// 좋아요
	int like;
	
	void contractionPrint() {
		System.out.println("게시물 구분자 : " + id + " / 게시물 제목 : "+ title + " / 작성자 : "+ writer);
	}
	
	void detailPrint() {
      	System.out.println("title : " + title);
    	System.out.println("writer : " + writer);
    	System.out.println("writeDate : " + writeDate);
    	System.out.println("contents : " + contents);
    	System.out.println("like : " + like);
    
	}
}

public class Sample01 {
	
	final static Board[] BOARD_LIST = new Board[3]; 
 
	// 코드의 구조화를 위한 메서드 작성
	// static으로 작성
	
	// 게시물 작성 기능
	public static void writeBoard() {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("게시물 작성");
    	
    	for(int i =0; i < BOARD_LIST.length; i++) {
            // for (Board board : BOARD_LIST) {
    		if( BOARD_LIST[i] != null) continue;
    		
    		BOARD_LIST[i] = new Board();
    		
    		BOARD_LIST[i].id = i; // 구분자 -> 순서 말하는 듯
    		
    		setBoard(i);

        	break; // 등록 완료하면 처음으로 돌아가는 기능을 위해
        
    	}
	}
	
	// 게시물 목록 보기
	public static int getBoardList() {
		
    	System.out.println("게시물 목록");
    	
    	// BOARD_LIST 배열에서 요소를 하나씩 꺼내서 board에 넣음
    	for(Board board : BOARD_LIST) { // writeBoard()에서 BOARD_LIST[i] = new Board()로 배열 요소에 객체 생성 해놨음
            
    		// 꺼낸 board 요소가 null이면 다음 요소를 꺼내옴
    		if(board == null) continue;
        	  board.contractionPrint();
    	}
    	
    	Scanner sc = new Scanner(System.in);
    	// 게시물 목록에서 특정 게시물 구분자를 입력하면 해당 게시물의 상세 내용을 보여줌
    	System.out.println("게시물을 선택하세요. (-1을 입력하면 처음 화면으로 돌아갑니다.)");
    	int selectBoardId = sc.nextInt();
    	sc.nextLine();
    	 
    	if(selectBoardId >= BOARD_LIST.length) { // 어떻게 하면 다시 위로 돌아갈지, while말고
    		System.out.println("3이상의 게시물은 없습니다."); 
    		// 재귀 함수로 자기 자신을 다시 호출
    		getBoardList();
    		return 0;
    	}
    	
    	if(selectBoardId < -1) {
    		System.out.println("잘못된 입력입니다.");
    		getBoardList();
    		return 0;
    	}
    	
    	// 만약 -1을 입력하면 처음화면으로 돌아옴
    	if(selectBoardId == -1) {
    		return 0;
    	}
    	
    	BOARD_LIST[selectBoardId].detailPrint();
    	
    	// 게시물 상세에서 수정하기를 선택하면 수정을 할 수 있음
    	System.out.println("1. 수정 / 0. 처음으로");
    	int updataSelect = sc.nextInt();
    	
    	if(updataSelect==0) return 0;
    	// 수정이 완료되면 처음화면으로 돌아옴
    	BOARD_LIST[selectBoardId] = new Board();
    	
    	setBoard(selectBoardId); // 수정할 끄니까

    	return 0;
    	
	}
	
	static void setBoard(int i) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("타이틀 : ");
		BOARD_LIST[i].title = sc.nextLine();
		
    	System.out.print("작성자 : ");
    	BOARD_LIST[i].writer = sc.nextLine();
    	
    	System.out.print("작성 날짜 및 시간 : ");
    	BOARD_LIST[i].writeDate = sc.nextLine();
    	
    	System.out.print("내용 : ");
    	BOARD_LIST[i].contents = sc.nextLine();

	}
	
	
	public static void main(String[] args) { // static이 붙어서 클래스에서 선언된 인스턴스 변수 호출 불가
		// 프로그램은 사용자가 종료를 하기 전 까지 계속 실행되어야 함
		// 사용자로부터 입력을 받아
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		
		while(power) {
		// 게시물 작성, 게시물 목록 기능을 선택할 수 있음
        System.out.println("1. 게시물 작성 / 2. 게시물 목록 / 0. 종료");
        int mainSelectNumber = sc.nextInt();
        sc.nextLine(); // nextInt()는 숫자만 인식하고 enter는 인식 안해서 엔터 담을 nextLine() 추가로 적어줌
        
        if(mainSelectNumber < 0 || mainSelectNumber >2) { // 처음엔 검증하기
        	System.out.println("잘못된 번호를 선택했습니다.");
        	continue; // 다음 반복 순서 진행, 처음으로 돌아가게 됨
        }
        
        // 게시물 작성을 선택하면 구분자 지정, 타이틀, 작성자, 작성 날짜 및 시간, 내용을 입력할 수 있음
	       // 입력이 완료되면 게시물이 자동 등록됨
		   // 등록이 완료되면 처음화면으로 돌아옴
        if(mainSelectNumber == 1) writeBoard();
        
		// 게시물 목록을 선택하면 작성된 게시물을 모두 보여줌 (게시물 구분자, 게시물 제목, 작성자만 출력)
        if(mainSelectNumber == 2) getBoardList();

		// 처음 화면일 시 종료를 선택하면 프로그램이 종료됨
        if(mainSelectNumber == 0) {
        	System.out.println("프로그램 종료");
        	// 1. while문 조건을 false
        	power = false;
        	// 2. break문으로 while문 강제 종료
        	// 3. return문으로 main 메서드를 종료
        	sc.close();
        }
		}
	}
}
