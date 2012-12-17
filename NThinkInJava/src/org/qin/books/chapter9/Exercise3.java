package org.qin.books.chapter9;
//import static org.qin.books.util.PrintClass.*;

class Animal {
	void print() { 
		System.out.println("Animal.print()");
	}	
}

class Cat extends Animal {
	
	public Cat() {
		super.print();
		
	}
	
	void print() { 
		System.out.println("Cat.print()");
	}
}

public class Exercise3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Cat();
	}

}
