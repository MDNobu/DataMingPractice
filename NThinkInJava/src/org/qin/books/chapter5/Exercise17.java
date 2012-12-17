package org.qin.books.chapter5;
import static org.qin.books.util.PrintClass.*;

public class Exercise17 {
	
	static int count = 0;
	
	public Exercise17() {
		count++;
		print("constructor is called" + count);		
	}
	
	public String toString() {
		return super.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise17[] list = new Exercise17[10];
		for(int i=0; i < 10; i++) {
			list[i] = new Exercise17();
		}
	}

}
