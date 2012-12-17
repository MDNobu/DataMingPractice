package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise20 {
	public static final Map<Character, Integer> vowels = new HashMap<Character, Integer>();
	static {
		vowels.put('a', 0);
		vowels.put('e', 0);
		vowels.put('i', 0);
		vowels.put('o', 0);
		vowels.put('u', 0);
	}
	
	public static Map<Character, Integer> countVowel(String s) {
		Map<Character, Integer> vowelMap = new HashMap<Character, Integer>(vowels);
		char[] cs = s.toCharArray();
		for(char c : cs) {
			Integer i = vowelMap.get(c);
			if (i != null) {
				vowelMap.put(c, i + 1);
			}
		}
		return vowelMap;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		Map<Character, Integer> vowelSum = new HashMap<Character, Integer>(vowels);
		while((line = br.readLine()) != null) {
			String[] strs = line.split("\\W+");
			for(String bstr : strs) {
				String str = bstr.toLowerCase();
				Map<Character, Integer> vowelMap = countVowel(str);
				print(vowelMap);
				for(Character c : vowelMap.keySet()) {
					int i = vowelSum.get(c);
					vowelSum.put(c, i + vowelMap.get(c));
				}
			}
		}
		print(vowelSum);
	}
}
