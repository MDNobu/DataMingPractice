package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Gerbil {
	private int gerbilNumber;
	private String gerName;
	public int getGerbilNumber() {
		return gerbilNumber;
	}
	public Gerbil(String name) {
		this(0, name);
	}
	
	public Gerbil(int num, String name) {
		gerbilNumber = num;
		gerName = name;
	}
	
	public void hop(Iterator<Gerbil> it) {
		while (it.hasNext()) {
			Gerbil g = it.next();
			print(g.getGerbilNumber() + "\thooping");
		}
	}
	
	public String toString() {
		return gerName;
	}
}

public class Exercise1 {
	
	public static void main(String[] args) {
		/*List<Gerbil> lb = new ArrayList<Gerbil>();
		for (int i =0; i < 15; i++) {
			lb.add(new Gerbil("Gerbil" + i));
		}*/
		/*for (int i = 0; i < lb.size(); i++) {
			Gerbil g = lb.get(i);
			g.hop();
		}*/
		//new Gerbil(5).hop(lb.iterator());
		Map<String, Gerbil> msg = new HashMap<String, Gerbil>();
		for (int i = 0; i < 15; i++) {
			msg.put("Gerbil" + i, new Gerbil("Gerbil" + i));
		}
		Iterator<String> it = msg.keySet().iterator();
		while (it.hasNext()) {
			print(msg.get(it.next()));
		}
	}
}
