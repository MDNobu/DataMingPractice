package org.qin.books.chapter5;

public class CharAddTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char c = '\uffff';
		System.out.println(c);
		System.out.println((int)c);
		c++;
		int d = c ;
		System.out.println(d);
		System.out.println((int)d);
		
	}

}
