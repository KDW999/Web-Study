package board;
import java.util.*;

public class Main {
	private List<User> database = new ArrayList<User>();
	
	// 회원 등록
	// id는 0이상 이어야 하고 password, name, telNumber는 빈값도 아니고 null도 아니어야 한다.
	
	private boolean createUser(int id, String password, String name, String telNumber) {
		// 파라미터가 정상 값이지 검증
		if(id < 0) return false;
		if(password.isEmpty() || name.isEmpty() || telNumber.isEmpty()) return false;
		if(password == null || name == null || telNumber == null) return false;
	
		// 아이디 중복 체크
		if(checkOverlap(id)) return false;
		
		// 관리하고자 하는 객체 생성
		User user = new User(id, password, name, telNumber);
		// 생성 객체를 데이터베이스에 삽입
		database.add(user);
		System.out.println(database);
		// 삽입 결과를 반환
		return true;
	}
	// 회원 정보 보기
	private User readUser(int id) {
		// 파라미터가 정상 값인지 검증
		if(id < 0) return null;
		// 데이터베이스에서 해당 id를 검색
		User user = selectUser(id);
		// 검색 결과 반환
		return null;
	}
	
//	UpdataUserDto dto;
//	dto.getid();
	
	// 회원 정보 수정
	private User updateUser(UpdataUserDto dto) {
		int id = dto.getId();
		// 입력된 id값 검증
		if(id < 0) return null;
		// 데이터베이스에서 입력받은 id에 해당하는 user정보를 불러옴
		User user = selectUser(id);
		// 입력받은 id에 해당하는 user정보가 있는지 검증
		if(user == null) return null;
		// 입력받은 패스워드, 해당 유저의 패스워드가 같은지 검증
		String password = dto.getPassword();
		if(!password.equals(user.getPassword())) return null;
		// 유저 정보 변경
		String name = dto.getName();
		String telNumber = dto.getTelNumber();
		user.setName(name);
		user.setTelNumber(telNumber); 
		return null;
	}
	// 회원 삭제
	private boolean deleteUser(int id) {
		// 입력된 id값 검증
		if(id < 0) return false;
		// 입력받은 id에 해당하는 user의 인덱스를 가져옴
		int index = getUserIndex(id);
		// index -1(존재하는 id)인지 검증
		if(index == -1) return false;
		database.remove(index);
		return false;
	}
	// 회원 리스트
	private List<User> readUserList(){
		return database;
	}

	// 메인 메서드
	public static void main(String[] args) {
		User user;
		Main main = new Main();
		main.createUser(5, "a", "b", "c");

	}
	
	// 회원 아이디가 중복되는지 검사하는 메서드
	private boolean checkOverlap(int id) {
		for(User user : database) {
			if(user.getId() == id) return true;
		}
		return false;
	}
	
	// 특정 회원 아이디를 database에서 검색하는 메서드
	private User selectUser(int id) {
		for(int i=0; i < database.size(); i++) {
			if(database.get(i).getId() == id) return database.get(i);
		}
		return null;
	}
	
	// 특정 회원 아이디를 database에서 검색해서 해당 인덱스를 반환하는 메서드
	private int getUserIndex(int id) {
		for(int i=0; i<database.size(); i++) {
			if(database.get(i).getId() == id) return i;
		}
		return -1;
	}

}
