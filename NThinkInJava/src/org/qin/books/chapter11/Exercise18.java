package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Exercise18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> tesMap = new HashMap<Integer, String>();
		for(int i = 0; i < 10; i++) {
			tesMap.put(i, "String" + i);
		}
		print(tesMap);
		for(Integer i : tesMap.keySet()) {
			print(i.hashCode());
		}
		for(Entry<Integer, String> e : tesMap.entrySet()) {
			print(e.hashCode());
		}
		Map<Integer, String> linkMap = new LinkedHashMap<Integer, String>();
		for(int i = 0; i < 10; i++) {
			linkMap.put(i, "String" + i);
		}
		print(tesMap);
		for(Integer i : tesMap.keySet()) {
			print(i.hashCode());
		}
		for(Entry<Integer, String> e : tesMap.entrySet()) {
			print(e.hashCode());
		}
	}

}
