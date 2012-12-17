package org.qin.books.chapter10;
import static org.qin.books.util.PrintClass.*;

import java.util.ArrayList;
import java.util.List;

public class MyController {
	private List<MyEvent> lm = new ArrayList<MyEvent>();
	
	public void addMyEvent(MyEvent e) {
		lm.add(e);
	}
	
	public void run() {
		while (lm.size() > 0) {
			for (MyEvent m : new ArrayList<MyEvent>(lm)) {
				if (m.ready()) {
					print(m);
					m.action();
					lm.remove(m);
				}
			}
		}
	}
}
