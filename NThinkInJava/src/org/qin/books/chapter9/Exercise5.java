package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.print;

import java.lang.reflect.Method;

import org.qin.books.chapter8.CDMA;


public class Exercise5 implements CDMA{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(CDMA.class.getMethods());
		for (Method m : CDMA.class.getMethods()) {
			print(m.getName());
		}
	}

	@Override
	public boolean connect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		
		return "get a message";
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}

}
