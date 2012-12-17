package org.qin.books.chapter8;

import static org.qin.books.util.PrintClass.print;

public class Star extends Circle {

	@Override
	public void draw(){ print("Star.draw()");}
	
	@Override
	public void erase() {print("Star.erase()");}
}
