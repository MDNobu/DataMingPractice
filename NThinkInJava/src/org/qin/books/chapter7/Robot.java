package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class Component1 {
	public Component1() {
		print(this.getClass().getCanonicalName());
	}
	
	public void dispose() {
		print("Erasing Component1");
	}
}

class Component2 {
	public Component2() {
		print(this.getClass().getCanonicalName());
	}
	public void dispose() {
		print("Erasing Component2");
	}
}

class Component3 {
	public Component3() {
		print(this.getClass().getCanonicalName());
	}
	public void dispose() {
		print("Erasing Component3");
	}
}

public class Robot {
	
	protected Component1 c1= new Component1();
	protected Component2 c2= new Component2();
	protected Component3 c3= new Component3();
	
	public Robot() {
		print(Robot.class);
	}
	
	public void dispose() {
		print("Erasing Robot");
		c1.dispose();
		c2.dispose();
		c3.dispose();
		print("Erase complete");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Stem().dispose();

	}

}

class Stem extends Robot{
	public Stem() {
		print(this.getClass().getCanonicalName());
	}
	
	public void dispose() {
		print("Erasing Stem");
		super.dispose();
		print("Erase Stem complete");
	}
}
