package algorhitm;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		String[] keymap = { "AA", "CC" };
		String[] targets = { "B", "BBD" };
		
		Set<String> set = new HashSet<>(Arrays.asList(keymap)); // keymap 배열을 List로 변경한 걸 초기값으로 삽입
        System.out.println(set+ " "+ set.size());
		set.remove(""); // 뭘까.. 뭘 삭제한거지
		System.out.println(set+ " "+ set.size());
	}

}
