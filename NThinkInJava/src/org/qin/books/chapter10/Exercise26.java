package org.qin.books.chapter10;
import static org.qin.books.util.PrintClass.*;

class Outer1 {
	class Inner1 {
		Inner1() {
			print("Inner1 constructor");
		}
	}
}

class Outer2 {
	class Inner2 extends Outer1.Inner1{
		Inner2(Outer1 o) {
			o.super();
			print("Inner2 constructor");
		}
	}
}

public class Exercise26 {
	public static void main(String[] args) {
		Outer1 o1 = new Outer1();
		Outer2.Inner2 oi2 = new Outer2().new Inner2(o1);
	}
}
