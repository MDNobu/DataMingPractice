package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

public class Exercise18 {
	
	public static final int size = 18;
	public static int count;
	final int id = count++;
	
	private Exercise18() { print(toString());	}
	
	public static Exercise18 getExercise18() {
		if (count < 18) {
			return new Exercise18();
		}
		return null;
	}
	
	public String toString() {
		return super.toString() + "*****" + id;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			Exercise18.getExercise18();
		}
		print(null);
	}
}
