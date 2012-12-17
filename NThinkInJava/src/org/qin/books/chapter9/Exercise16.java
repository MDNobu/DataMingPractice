package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.*;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class Prototype {
	private static Random rand = new Random(47);
	private static final char[] alphbet ;
	static {
		String str = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
		alphbet = str.toCharArray();
	}
	public char next() {
		return alphbet[rand.nextInt(alphbet.length)];
	}
}

class PrototypeAdapter extends Prototype implements Readable {
	private int count;

	public PrototypeAdapter(int size) {
		this.count = size;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;
		}

		cb.append(next());

		return 10;
	}

}

public class Exercise16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(new PrototypeAdapter(50));
		while (s.hasNext()) {
			print(s.next());
		}
	}

}
