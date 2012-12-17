package org.qin.books.chapter9;
import static org.qin.books.util.PrintClass.*;

public class Apply {
	
	public static void process(Processor p, Object o) {
		print(p.name() + "Apply process");
		print(p.process(o));
	}
}
