package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class LazyClass {
	String age;
	
	public String toString() {
		if (age == null) {
			age = "wang";
		}
		
		return super.toString() + age;
	}
}

public class Exercise1 {
	
	private String name ;
	private LazyClass lc;
	
	public Exercise1(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		if (lc == null) {
			lc = new LazyClass();
		}
		if (name == null) {
			name = "qin";
		}		
		return super.toString()+ "\n" + name + "\n" + lc.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise1 e = new Exercise1("w's tragedy");
		System.out.println(e.lc);
		
		print(e.name);
		System.out.println(e);
		System.out.println(e.lc.age);
		
		

	}

}
