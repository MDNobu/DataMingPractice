package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.print;

class A {
	A(String a) {
		print("A constructor is called");
	}
};
class B {
	B(String b) {
		print("B constructor is called");
	}
};
class C extends A {
	B b ;
	public C(String a, String b) {
		super(a);
		this.b = new B(b);
	}
}

class NewExercise4 extends org.qin.books.chapter6.Exercise4 {

	public NewExercise4(String field1) {
		super(field1);
		
	}
	
	public void list() {
		super.list();
	}
	
}

public class Exercise5 extends org.qin.books.chapter6.Exercise4{

	public Exercise5(String field1) {
		super(field1);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C c = new C("name", "age");
		org.qin.books.chapter6.Exercise4 e = new org.qin.books.chapter6.Exercise4("test");
		NewExercise4 e5 = new NewExercise4("test");
		e5.list();
	}

}
