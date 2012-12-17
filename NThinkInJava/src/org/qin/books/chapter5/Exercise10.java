package org.qin.books.chapter5;


public class Exercise10 {
	
	boolean test = true;

	@Override
	protected void finalize() throws Throwable {
		if (test) {
			
			System.out.println("fianlize is called");
			super.finalize();
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise10 e = new Exercise10();
		//e = null;
		new Exercise10();
		new Exercise10();
		new Exercise10();
		new Exercise10();
		
		System.gc();
	}

}
