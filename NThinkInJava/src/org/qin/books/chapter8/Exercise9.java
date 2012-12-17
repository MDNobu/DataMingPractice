package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

interface Rodent {
	String type(); 
}

class Mouse implements Rodent {

	@Override
	public
	String type() {
		// TODO Auto-generated method stub
		return "Mouse";
	}
	
}

class Gerbil implements Rodent {

	@Override
	public
	String type() {
		return "Gerbil";
	}
	
}

class Hamster implements Rodent {

	@Override
	public
	String type() {
		// TODO Auto-generated method stub
		return "Hamster";
	}
	
}

abstract class Human {}


public class Exercise9 {	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(new Hamster().type());
		
	}

}
