package algorhitm;

import java.util.*;

class Test1 {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		String[] keymap = { "AA", "CC" };
		String[] targets = { "B", "BBD" };
		t1.solution(keymap, targets);
	}
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Set<String> set = new HashSet<>(Arrays.asList(keymap)); // keymap 배열을 List로 변경한 걸 초기값으로 삽입
        set.remove(""); // 뭘까.. 없어도 정답인데 제출할 때 지우는 걸 깜빡한건가?

        for (int i = 0; i < targets.length; i++) { // targets

            for (int l = 0; l < targets[i].length(); l++) { // char
                int k = 101; // 키의 원소의 길이가 100이하라 101로 잡은 듯?

                for (String j : set) { // set
                    int index = j.indexOf(targets[i].charAt(l)); // indexOf()는 문자열에서 특정 인덱스를 찾는 메서드, 못찾으면 -1 반환
                                                                 // 만들 수 있는 문자열인지 쉽게 확인 가능
                                                                 // indexOf()는 앞에서 부터 탐색, lastIndexof()는 뒤에서 부터 탐색

                    if (index == -1) continue;
                    else if (index < k) k = index; // 같은 문자가 나왔을 경우 k에 저장해둔 값과 비교하여 더 빠른 순서의 문자를 저장
                }


                if (k == 101) { // 101일 경우 만들 수 없는 문자열이라 -1 저장
                    answer[i] = -1;
                    break;
                } 
                else answer[i] += (k + 1); // 만들 수 있는 문자일 경우 배열의 한 요소에 k값들 저장
            }
        }
        return answer;
    }
}