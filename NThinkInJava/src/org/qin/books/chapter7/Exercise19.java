package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class WBase {
	final void test() {
		print("test base");
	}
}

class Derived extends WBase {
	
}


public class Exercise19 {
	
	final String name;
	
	public Exercise19(String name) {
		this.name = name;
	}
	
	public Exercise19() {
		name = "no name";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise19 e = new Exercise19("wang");
		print(e.name);
	}

}
