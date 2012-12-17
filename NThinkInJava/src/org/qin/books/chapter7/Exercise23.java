package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class Exercise23I {
	
	static int ele1 = 5;
	static int ele2 = get();
	
	public static void info() {
		print("static method is called");
	}
	
	public static int get() {
		print("static get is called");
		return 100;
	}
	
	static {
		print("class is loading");
		print(ele1);
	}		
	public Exercise23I() {
		print("construtor is called");
	}	
	
	public void test() {
		print(get());
	}
	
}

public class Exercise23 {	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new Exercise23I();
		Exercise23I.info();
		new Exercise23I().test();
	}
}
