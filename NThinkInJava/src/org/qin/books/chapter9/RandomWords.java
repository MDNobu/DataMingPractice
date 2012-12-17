package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.print;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {
	
	private static Random rand = new Random(47);
	
	private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray();
	private static final char[] VOWELS = "aeiou".toCharArray();
	
	private int count;
	
	public RandomWords(int size) {
		this.count = size;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;
		}
		
		cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
		for (int i = 0; i < 4; i++) {
			cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
			cb.append(LETTERS[rand.nextInt(LETTERS.length)]);
		}
		return 10;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(10));
		while (s.hasNext()) {
			//print(s.next());
			System.out.println(s.next());
		}
	}

}
