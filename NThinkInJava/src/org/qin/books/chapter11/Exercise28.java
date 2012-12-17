package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.util.PriorityQueue;
import java.util.Random;

class MyClass { }

public class Exercise28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		PriorityQueue<Double> pq = new PriorityQueue<Double>();
		for (int i = 0; i < 10; i++) {
			pq.offer(rand.nextDouble());
		}
		Double num;
		while((num = pq.poll()) != null	) {
			print(num);
		}
		PriorityQueue<MyClass> mpq = new PriorityQueue<MyClass>();
		mpq.offer(new MyClass());
		mpq.offer(new MyClass());
	}

}
