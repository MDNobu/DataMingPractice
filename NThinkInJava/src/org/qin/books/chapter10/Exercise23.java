package org.qin.books.chapter10;

import static org.qin.books.util.PrintClass.*;

//define a interface with three method
interface U {
	boolean isU();

	int index();

	void handle(int i);
}

class A {
	// a field to prove the callback
	public int w = 45;

	public U getU() {
		return new U() {
			@Override
			public boolean isU() {
				return true;
			}

			@Override
			public int index() {
				return w;
			}

			@Override
			public void handle(int i) {
				w = i;
				print(i);
				print("this is a anounymous impletation in A");
			}
		};
	}
}

class B {
	private U[] us = new U[15];
	private int i = -1;

	public void addU(U u) {
		if (++i < us.length) {
			us[i] = u;
			u.handle(i);
		}
	}

	public void clear() {
		for (int j = 0; j < i; j++) {
			us[j] = null;
		}
		i = -1;
	}

	public void trace() {
		for (U u : us) {
			print(u.index());
			print(u.isU());
			u.handle(6666);
		}
	}
}

public class Exercise23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		for (int i = 0; i < 15; i++) {
			b.addU(a.getU());
		}
		for (int i = 0; i < 15; i++) {
			printnl(a.w + "  ");
		}
		b.trace();
		for (int i = 0; i < 15; i++) {
			printnl(a.w + "  ");
		}
	}
}
