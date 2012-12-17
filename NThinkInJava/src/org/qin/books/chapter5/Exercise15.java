package org.qin.books.chapter5;
import static org.qin.books.util.PrintClass.*;

public class Exercise15 {
	
	String field1 = "world";
	
	{
		field1 = "Hello	";
		print("instance initialize");
	}
	
	public Exercise15	( ) {
		print("constructor is called");
		print(field1);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Exercise15();

	}

}
