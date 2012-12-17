package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.*;

class StrP implements Processor{	

	@Override
	public String name() {		
		return this.getClass().getSimpleName();
	}

	@Override
	public String process(Object o) {
		String str = (String)o;
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}

class ReverseP {
	public String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}


public class Exercise11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apply.process(new ReverseAdapter(new ReverseP()), "I am not a hero");
	}

}
