package org.qin.books.chapter9;

import static org.qin.books.util.PrintClass.*;

interface Coin {
	boolean isUp();
}

interface Dice {
	int getPoint();
}


interface GameFactory {
	
}

class CoinImple implements Coin {
	@Override
	public boolean isUp() {
		print("Coin Implementation ");
		return false;
	}	
}

class DiceImple implements Dice {
	@Override
	public int getPoint() {
		print("Dice Impletentation");
		return 0;
	}	
}


public class Exercise19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
