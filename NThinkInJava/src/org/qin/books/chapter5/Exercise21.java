package org.qin.books.chapter5;

public class Exercise21 {
	public static void main(String[]	args) {
		for(Moneys money :Moneys.values()) {
			System.out.println(money + " ordinal " + money.ordinal());
		}
		Moneys a = Moneys.JIAO;
		switch(a) {
			case JIAO:
				System.out.println("yi jiao");
				break;
			case YUAN:
				System.out.println("yi jiao");
				break;
			case WU:
				System.out.println("yi jiao");
				break;
			case SHI:
				System.out.println("yi jiao");
				break;
			case BAI:
				System.out.println("yi jiao");
				break;
		}
	}
}
