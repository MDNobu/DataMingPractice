package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

class GGerbil implements Rodent {

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


public class Exercise10 {	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Rodent> lr = new ArrayList<Rodent>();
		lr.addAll(Arrays.asList(
			new Mouse(), new GGerbil(), new Mouse(),
			new Hamster(), new GGerbil(), new Mouse()
		));
		Iterator<Rodent> it = lr.iterator();
		while(it.hasNext()) {
			print(it.next().type());
		}	
		print();
		print();
		ListIterator<Rodent> lit = lr.listIterator(lr.size());
		while(lit.hasPrevious()) {
			print(lit.previous().type());
		}
	}
}
