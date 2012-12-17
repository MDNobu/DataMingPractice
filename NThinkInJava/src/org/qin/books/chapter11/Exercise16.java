package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise16 {
	private static final Character[] cs = new Character[]{'a','e','i','o','u','A','E',
			'I', 'O','U'};
	public static final Set<Character> vowels = new HashSet<Character>(Arrays.asList(cs));
	static {
		//Character[] cs = new Character[]("aeiouAEIOU".toCharArray());
		
		//vowels.addAll(vowels, cs);
	}
	
	public static int countVowel(String s) {
		char[] cs = s.toCharArray();
		int count = 0;
		for(char c : cs) {
			if (vowels.contains(c)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		int sum = 0;
		while((line = br.readLine()) != null) {
			String[] strs = line.split("\\W+");
			for(String str : strs) {
				int count = countVowel(str);
				print(str + "\t" + count);
				sum += count;
			}
		}
		print(args[0] + "\t" + sum);
	}
}
