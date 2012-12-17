package org.qin.books.chapter8;

import static org.qin.books.util.PrintClass.*;

class Cycle {

	public int wheelNum = 0;

	public Cycle ride() {
		return this;
	}
	
	public int wheels() {
		return wheelNum;
	}
}

class Unicycle extends Cycle {
	{
		wheelNum = 1;
	}

}

class Bicycle extends Cycle {
	{
		wheelNum = 2;
	}
	
	public Bicycle() {
		wheelNum = 100;
	}
}

class Tricycle extends Cycle {
	public int wheelNum = 3;
	
	public int wheels() {
		return wheelNum;
	}
}

public class Exercise1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(new Cycle().getClass());
		print(new Unicycle().ride().getClass());
		print(new Bicycle().ride().getClass());
		print(new Tricycle().ride().getClass());
		Unicycle uni = new Unicycle();
		Bicycle bi = new Bicycle();
		Tricycle tri = new Tricycle();
		
		print(uni.wheels());
		print(bi.wheels());
		print(tri.wheels());
		
		print(tri.wheelNum);
		
	}

}
