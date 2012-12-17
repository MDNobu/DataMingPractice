package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

public class MyShapes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape[] s = new Shape[20];
		MyRandomShapeGenerator rsg = new MyRandomShapeGenerator(5);
		for (int i = 0; i < s.length; i++) {
			s[i] = rsg.getShape();
		}
		for (Shape sp : s) {
			sp.draw();
			//sp.erase();
			//sp.change();
			print();
		}
	}
}
