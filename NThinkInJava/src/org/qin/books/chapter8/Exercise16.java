package org.qin.books.chapter8;
import static org.qin.books.util.PrintClass.*;

class Status {
	
}

class GravityStatus extends Status{
	
}

class AirStatus extends Status {
	
}

class WaterStatus extends Status {
	
}

class Starship {
	private Status st = new GravityStatus();
	
	public void changeStatus (Status st) {
		this.st = st;
	}
	
	public String getStatus () {
		return st.getClass().getSimpleName();
	}
}

public class Exercise16 {
	public static void main(String[] args) {
		Starship s = new Starship();
		print(s.getStatus());
		s.changeStatus(new AirStatus());
		print(s.getStatus());
		s.changeStatus(new WaterStatus());
		print(s.getStatus());
	}
}
