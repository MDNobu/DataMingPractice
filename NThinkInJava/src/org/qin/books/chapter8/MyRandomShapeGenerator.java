package org.qin.books.chapter8;

import java.util.Iterator;
import java.util.Random;

public class MyRandomShapeGenerator implements Iterable{
	
	private Random rd = new Random(47);
	
	Shape[] shapes;
	
	public MyRandomShapeGenerator(int n) {
		shapes = new Shape[n];
	}
	
	public Shape getShape() {
		int i = rd.nextInt(4);
		Shape w;
		switch(i) {
		default:
		case 0:
			w = new Circle();
			break;
		case 1:
			w = new Square();
			break;
		case 2:
			w = new Triangle();
			break;
		case 3:
			w = new Star();
			break;
		}
		return w;
	}

	@Override
	public Iterator iterator() {		
		return new Iterator<Shape>() {
			private int index = 0;
			
			@Override
			public boolean hasNext() {				
				return index < shapes.length;
			}

			@Override
			public Shape next() {				
				return shapes[index++];
			}

			@Override
			public void remove() {
								
			}			
		};
	}
	
	public static void main(String[] args) {
		MyRandomShapeGenerator msg = new MyRandomShapeGenerator(10);
		Iterator<Shape> it = msg.iterator();
		while(it.hasNext()) {
			
		}
	}
}
