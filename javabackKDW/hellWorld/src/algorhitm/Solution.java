package algorhitm;

import java.util.*;

class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] keymap = { "AA", "CC" };
		String[] targets = { "B", "BBD" };
		s.solution(keymap, targets);
	}

	// 키를 누른 횟수에 따라 문자열을 고를 수 있다.
	// 키는 1번 부터 100번 까지, 나오는 문자들의 순서는 무작위 배치, 같은 문자가 다른 키에 있을수도
	// 같은 문자가 같은 키에 여러 번 있을 수도 있다. 심지어 할당되지 않은 문자열이 있을 수 있음
	// 원하는 문자열을 만들기 위해 키를 최소 몇 번 눌러야하는지
	// 문자열을 만들 수 없으면 -1
	
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
        	int sum = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				int count = minPress(keymap, targets[i].charAt(j)); // press 메서드는 구하려는 문자를 키를 최소로 눌러서 구한 횟수를 return
				if (count == -1) { // press 메서드는 keymap과 targets의 문자들을 하나씩 비교해서 같은 문자가 없으면 -1 return해줌
					sum = -1; 
					break;
				}
				sum += count; // targets의 한 요소에 있는 문자들의 최소 횟수를 다 구한 뒤 합산
			}
			answer[i] = sum; 
		}
        for(int n : answer) System.out.println(n);
        return answer;
    }
    
    private int minPress(String[] keymap, char c) {
    	int min = -1;
    	for (int i = 0; i < keymap.length; i++) {
    		for (int j = 0; j < keymap[i].length(); j++) {
				if (keymap[i].charAt(j) == c) {
					if (min == -1) { // 구하려는 문자와 처음으로 같은 문자를 찾았을 경우
						min = j+1;
					} 
					else if (min > j) { // 같은 문자라도 최소 횟수를 위해서 더 앞에 있는 문자의 순서 저장 
						                // min > j+1이 아닌 이유 → j+1과 비교하면 바로 다음 순서에 오는 같은 문자는 연산을 못함
						min = j+1;
					}
					break; // 만드려는 한 문자의 최소 횟수 구했으니 다음 문자로
				}
			}
		}
    	
    	return min;
    }
}