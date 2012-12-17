package org.qin.books.chapter10;
import static org.qin.books.util.PrintClass.*;

class Outer {
	private int x = 12;
	private void show() {
		print("Outer.show()" + x);
	}
	
	public Inner getInner() {
		return new Inner() ;
	}
	
	public void changeInnerW(Inner i, int t) {
		i.w = t;
	}
	
	class Inner {
		
		private int w = 456;
		
		public void changeX (int a) {
			x = a;
			show();
		}
		
		public void iprint() {
			print(w);
		}
	}
}

public class Exercise6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer o1 = new Outer();
		Outer.Inner oi1 = o1.getInner();
		Outer o2 = new Outer();
		Outer.Inner oi2 = o2.new Inner();
		oi1.iprint();
		o1.changeInnerW(oi1, 123);
		oi1.iprint();
		oi2.iprint();
		o2.changeInnerW(oi1, 123456);
		oi2.iprint();
		oi1.iprint();
	}
}
