package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;
import static org.qin.books.util.PrintClass.printnl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Exercise2 {
	
	public static  void insert(List<Integer> l, int i) {
		int mid = ( 0 + l.size()) /2;
		ListIterator lit = l.listIterator(mid);
		lit.add(i);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> ci  = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
			ci.add(i);
		}
		/*for (Integer i : ci) {
			printnl(i + "  ");
		}*/		
		print();
		print(ci);
		insert(ci, 500);
		print(ci);
	}

}
