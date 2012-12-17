package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

public  class Triangle extends Shape {
	@Override
	public void draw(){ print("Triangle.draw()");}
	
	@Override
	public void erase() {print("Triangle.erase()");}
}
