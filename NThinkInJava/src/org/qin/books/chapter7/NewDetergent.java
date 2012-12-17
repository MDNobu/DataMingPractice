package org.qin.books.chapter7;
import static org.qin.books.util.PrintClass.*;

public class NewDetergent extends Detergent{	
	
	//extend method 
	public void sterilize() {
		append("sterilize()");
	}
	
	//overwrite method
	@Override
	public void scrub() {
		super.scrub();
		append("NewDetergent.scrub()");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewDetergent nd =new  NewDetergent();
		print(nd);
		nd.apply();
		nd.dilute();
		nd.foam();
		nd.scrub();
		nd.sterilize();
		
		print(nd);
		
	}

}
