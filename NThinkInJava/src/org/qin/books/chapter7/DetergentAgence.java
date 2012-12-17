package org.qin.books.chapter7;

import static org.qin.books.util.PrintClass.print;

public class DetergentAgence {
	String agent = "default";
	Detergent dt = new Detergent();
	
	public DetergentAgence(String agent) {
		this.agent = agent;
	}
	
	@Override
	public String toString() {
		return dt.toString();
	}
	
	public void append(String a) {dt.append(a); }
	public void dilute() { dt.dilute(); }
	public void apply() { dt.apply(); }
	public void scrub() { dt.scrub(); }
	public void foam() { dt.foam(); }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DetergentAgence x = new DetergentAgence("wang");
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    print(x);
	    print("Testing base class:");   
	}

}
