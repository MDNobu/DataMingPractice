package org.qin.books.chapter11;

import java.util.Queue;

class Command {
	String name;
	public Command(String name) {
		this.name = name;
	}
	
	String operation() {
		return name;
	}	
}

class Commanders {
	Queue<Command> commanders;
	public Queue<Command> addCommand(Command c) {
		commanders.offer(c);
		return commanders;
	}
}

class CommandConsumer {
	public void consumeCommand(Queue<Command> q) {
		q.remove();
	}
}

public class Exercise27 {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
