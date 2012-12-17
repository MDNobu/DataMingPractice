package org.qin.books.chapter9;

public class ReverseAdapter implements Processor {

	private ReverseP rp;

	public ReverseAdapter(ReverseP rp) {
		super();
		this.rp = rp;
	}

	@Override
	public String name() {
		
		return rp.getClass().getSimpleName();
	}

	@Override
	public Object process(Object o) {
		String str = (String)o;
		return rp.reverse(str);
	}

}
