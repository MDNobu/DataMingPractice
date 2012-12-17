package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

class Base {
	Base() {
		print("Base constructor is called");
	}
}

public class Exercise4 extends Base{
	
	
	protected String field1; 
	
	/*public Exercise4(String field1) {
		this.field1 = field1;
		print("Exercise4 constructor is called");
	}*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise4 e = new Exercise4();

	}

}
