package org.qin.books.chapter6;
import static org.qin.books.util.PrintClass.print;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AllTest {

	@Test
	public void test() {
		Exercise4  e = new Exercise4("name"	);
		//assertThat(e.field1, is("name"));
		print(e.field1);
		e.field1 = "age";
		print(e.field1);
	}
	
	
	
}
