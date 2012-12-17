package org.qin.books.chapter5;

public class Exercise1 {
	
	String ele1;
	
	public Exercise1() {
		System.out.println("an exercise1 objected is being created");
	}
	
	public Exercise1(String para) {
		this();
		System.out.println(para);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise1 e1 = new Exercise1("a consctrudor with a param");
		System.out.print(e1.ele1);

	}
}
