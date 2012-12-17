package org.qin.books.chapter5;
import static org.qin.books.util.PrintClass.*;

public class Exercise14 {
	
	public static int a = 2;
	public static int b;
	
	static {
		b = 56;
	}
	
	public static void show() {
		print(a + " " + b);
	}
	
	

	public Exercise14() {
		show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Exercise14();
	}

}
