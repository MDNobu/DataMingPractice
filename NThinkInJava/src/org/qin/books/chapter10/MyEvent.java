package org.qin.books.chapter10;

public abstract class MyEvent {
	private long eventTime;
	protected final long delayTime;
	public MyEvent(long delayTime) {
		this.delayTime = delayTime;
		
	}
	
	public void start() {
		eventTime = System.nanoTime() + delayTime;
	}
	
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}
	
	public abstract void action() ;
	
}
