package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.*;

abstract class X {
	
}

class Y extends X {
	
	public static void get(X x) {
		Y y = (Y)x;
		print(y.getInt());
	}
	
	public int getInt() {
		return 50;
	}
	
	public void show() {}
	
	
}


public class Exercise4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Y.get(new Y());
	}

}
