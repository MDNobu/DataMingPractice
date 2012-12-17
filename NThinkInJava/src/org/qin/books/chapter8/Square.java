package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

public  class Square extends Shape {
	@Override
	public void draw(){ print("Square.draw()");}
	
	@Override
	public void erase() {print("Square.erase()");}
	
	@Override
	public void change() {
		print("Square.change()");
	}
}
