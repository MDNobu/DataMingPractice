package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class EWBase {
	EWBase(int a) {
		print("Base constructor is called" + a	);
	}
}



public class Exercise8 extends EWBase{
	
	public Exercise8() {
		super(5);
		print("default constructor");
	}
	
	public Exercise8(int b) {
		super(b);
		print("non default constructor");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Exercise8();
		new Exercise8(3);

	}

}
