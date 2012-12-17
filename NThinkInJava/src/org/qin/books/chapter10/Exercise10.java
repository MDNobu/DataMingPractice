package org.qin.books.chapter10;
import static org.qin.books.util.PrintClass.*;

class NOuter {
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
	
	public static class Inner {
		
		private int w = 456;
		
		public class InInner {
			
		}
	}
}

public class Exercise10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NOuter.Inner();
	}
}
