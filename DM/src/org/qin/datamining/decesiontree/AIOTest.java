package org.qin.datamining.decesiontree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AIOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = args[0];
		BufferedReader reader = null;		
		reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while((line = reader.readLine()) != null) {
			if( line.matches("^\\s*//.*$")) {
				System.out.print(line);	
				System.out.println("\ttrue");
			}
		}
		reader.close();
		/*String test = new String("abcdefg");
		System.out.println(test.matches("cd"));
		System.out.println(test);*/
	}

}
