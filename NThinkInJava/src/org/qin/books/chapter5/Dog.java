package org.qin.books.chapter5;

public class Dog {
	
	public void bark(int d) {
		System.out.println("barking");
	}
	
	/*public void bark(char d) {
		System.out.println("wangwang");

	}*/
	
	public void bark() {
		System.out.println("howling");

	}
	
	public void bark(boolean d) {
		System.out.println("cry");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog d = new Dog();
		d.bark();
		d.bark('c');
		d.bark(55);
		d.bark(true);
	}

}
