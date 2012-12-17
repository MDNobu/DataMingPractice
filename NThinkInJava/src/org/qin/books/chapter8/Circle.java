package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

public  class Circle extends Shape {
	@Override
	public void draw(){ print("Circle.draw()");}
	
	@Override
	public void erase() {print("Circle.erase()");}
}
