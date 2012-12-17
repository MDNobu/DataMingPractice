package org.qin.books.chapter5;
import static org.qin.books.util.PrintClass.*;

public class Exercise190 {
	
	public static void test(String... args) {
		for (String str : args) {
			print(str);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test(new String[]{"Stanford", "Tinghua", "Peking", "Tokyo", "Hongkong"});
	}

}
