package chapter04;

import java.util.*;

public class Example05 {

	public static void main(String[] args) {
		// Set 클래스
		Set<String> hashSet = new HashSet<String>(); // 정렬 안되는 Set
		
		// set 구조에 데이터를 추가
//		hashSet.add("apple");
//		hashSet.add("carrot");
//		hashSet.add("apple");
//		hashSet.add("banana");
//		hashSet.add("apple");
//		System.out.println(hashSet);
//		
//		// set은 순서가 없어서 인덱스로 접근 불가
//        // set[0];
//		// Iterator로 set 컬렉션에 접근
//		
//		Iterator<String> hashSetIterator = hashSet.iterator();
//		
//		// Iterator의 hasNext() 메서드로 다음 요소가 있으면 반복
//		while(hashSetIterator.hasNext()) {
//			// Iterator의 next() 메서드로 다음 요소를 가져옴
//			System.out.println(hashSetIterator.next());
//		}
//		
//		Set<String> treeSet = new TreeSet<String>(); //  정렬되는 Set
//		
//		treeSet.add("apple");
//		treeSet.add("carrot");
//		treeSet.add("apple");
//		treeSet.add("banana");
//		treeSet.add("apple");
//		treeSet.add("hi");
//		System.out.println(" ");
//		
//		Iterator<String> treeSetIterator = treeSet.iterator();
//		while(treeSetIterator.hasNext()) {
//			System.out.println(treeSetIterator.next());
//		}
//		
//		// size() : 길이 혹은 크기를 가져옴
//		System.out.println(treeSet.size());
		
		
		// List Interface
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(4);
		num.add(8);
		num.add(16);
		num.add(32);
		num.add(64);
		
		Iterator<Integer> it = num.iterator();
		// 특정 위치에 특정 데이터 넣음
		num.add(2, 128);
		// 특정 위치 데이터 변경
		num.set(3, 6);
		// 특정 위치 데이터 제거
		num.remove(0);
		
		// List는 순서가 존재
//		for(int nums : num) {
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				System.out.println("오류요");
//			}
//		System.out.println(nums);
//		}
		
//		List<String> arrayList = new ArrayList<String>();
//		List<String> linkedList = new LinkedList<String>();
//		
//		long start = System.currentTimeMillis();
//		for(int i=0; i < 200000; i++) 	arrayList.add(0, String.valueOf(i));
//	    long end = System.currentTimeMillis();
//		System.out.println("ArrayList 작업 시간 : " + (end - start));
//		
//		start = System.currentTimeMillis();
//		for(int i=0; i < 200000; i++) 	linkedList.add(0, String.valueOf(i));
//	    end = System.currentTimeMillis();
//		System.out.println("LinkedList 작업 시간 : " + (end - start));
		
		// Map Interface
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		
		// hashmap에 데이터 추가할 땐 put
		hashMap.put("name", "KDW");
		hashMap.put("address", "Republic of Korea");
		
		// hashmap에서 특정한 키에 해당하는 값을 가져옴
		System.out.println("name : "+ hashMap.get("name"));
		System.out.println("address : "+ hashMap.get("address"));
		
		Set<String> keys = hashMap.keySet();
		Iterator<String> kI = keys.iterator();
		
		while(kI.hasNext()) {
			System.out.println(kI.next());
		}
		
		if(hashMap.containsKey("age")) System.out.println(hashMap.get("age"));
	}
}
