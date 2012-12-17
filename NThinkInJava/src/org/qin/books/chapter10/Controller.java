//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package org.qin.books.chapter10;
import java.util.*;

public class Controller {
  // A class from java.util to hold Event objects:
  private List<Event> eventList = new LinkedList<Event>();
  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
    while(eventList.size() > 0) {
      // Make a copy so you're not modifying the list
      // while you're selecting the elements in it:
     /* for(Event e : new LinkedList<Event>(eventList))
        if(e.ready()) {
          System.out.println(e);
          e.action();
          eventList.remove(e);
        }*/
    	List<Event> tmpList = new LinkedList<Event>(eventList);
    	Iterator<Event> it = tmpList.iterator();
    	while(it.hasNext()) {
    		Event e  = it.next();
    		if (e.ready()) {
    	          System.out.println(e);
    	          e.action();
    	          eventList.remove(e);    			
    		}
    	}
    }
  }
} ///:~
