//: polymorphism/music3/Music3.java
// An extensible program.
package org.qin.books.chapter8;

import static org.qin.books.util.PrintClass.print;

import java.util.Random;

class Instrument {
  void play(Note n) { print("Instrument.play() " + n); }
  String what() { return "Instrument"; }
  void adjust() { print("Adjusting Instrument"); }
  
  public String toString() {
	 return what();
  }
}

class Wind extends Instrument {
  void play(Note n) { print("Wind.play() " + n); }
  String what() { return "Wind"; }
  void adjust() { print("Adjusting Wind"); }
}	

class Percussion extends Instrument {
  void play(Note n) { print("Percussion.play() " + n); }
  String what() { return "Percussion"; }
  void adjust() { print("Adjusting Percussion"); }
}

class Stringed extends Instrument {
  void play(Note n) { print("Stringed.play() " + n); }
  String what() { return "Stringed"; }
  void adjust() { print("Adjusting Stringed"); }
}

class Brass extends Wind {
  void play(Note n) { print("Brass.play() " + n); }
  void adjust() { print("Adjusting Brass"); }
}

class Woodwind extends Wind {
  void play(Note n) { print("Woodwind.play() " + n); }
  String what() { return "Woodwind"; }
}	

class Guitar extends Instrument {
	void play(Note n) {
		print("guitar.play()" + n);
	}
	String what() { return "Guitar"; }
}

public class Music3 {
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Instrument[] e) {
    for(Instrument i : e)
      tune(i);
  }	
  
  public static class MusicGenerator {
	  
	  private Random rand = new Random(47);
	  
	  public Instrument next() {
		  int i = rand.nextInt(6);
		  Instrument m;
		  switch(i) {
		  default:
		  case 0:
			  m = new Wind();
			  break;
		  case 1:
			  m = new Percussion();
			  break;
		  case 2:
			  m = new Stringed();
			  break;
		  case 3:
			  m = new Brass();
			  break;
		  case 4:
			  m =new Woodwind();
			  break;
		  case 5:
			  m = new Guitar();
			  break;
		  }
		  return m;
	  }
	  
  }
  public static void main(String[] args) {
    // Upcasting during addition to the array:
	MusicGenerator mg = new MusicGenerator();
    Instrument[] orchestra = new Instrument[20];
    for (int i = 0; i < orchestra.length; i++) {
    	orchestra[i] = mg.next();
    	print(orchestra[i].hashCode());
    }    
    
    tuneAll(orchestra);
    print(orchestra[1]);
  }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
