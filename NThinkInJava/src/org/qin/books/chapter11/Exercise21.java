package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Exercise21 {
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		Map<String, Integer> wordCount = new HashMap();
		String line;
		while((line = br.readLine()) != null) {
			String[] words = line.split("\\W+");
			for(String word : words) {
				Integer i = wordCount.get(word);
				wordCount.put(word, i == null ? 1 : i + 1);
			}
		}
		wordCount.remove("");
		//print(wordCount);
		print(wordCount.entrySet());
		//Collections.sort(list, c)
		List<String> strList = new LinkedList<String>();
		strList.addAll(wordCount.keySet());
		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		
		//Define a map contains the sorted map
		Map<String, Integer> wordCountTwo = new LinkedHashMap();
		for(String str : strList) {
			wordCountTwo.put(str, wordCount.get(str));
		}
		print(wordCountTwo);
	}
}
