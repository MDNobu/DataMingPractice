package org.qin.books.chapter8;

import static org.qin.books.util.PrintClass.*;

class X {
	
	private static int count = 0;
	protected final int id = ++count;
	
	
	int a = 55;
	{
		print(a);
	}
	
	public X() {
		print("X constructor is called");
	}
	
	public void x() {
		print("X.x() is called");
		y();
	}

	public void y() {
		print("X.y() is called");
	}
	
	public int getId() {
		return id;
	}
}

class Y extends X {
	
	int b = 66;
	
	
	public Y() {
		print(b + "has been created");
		print("Y constructor is called");
	}
	
	@Override
	public void y() {
		print("Y.y() is called");
	}
}


public class Exercise10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		X x = new Y();
		Y y = new Y();
		print(x.getId());
		print(y.getId());		
	}

}
