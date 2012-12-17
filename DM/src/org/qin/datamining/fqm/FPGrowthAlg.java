package org.qin.datamining.fqm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FPGrowthAlg  {
	
	public static final int THRESHOLD = 10;

	

	
	public static void main(String[] args) throws IOException {
		Map<String, List<String>> transactions = DMIOUtils.readMapWithoutID(args[0]);
		FPTree fp = new FPTree(transactions, FPGrowthAlg.THRESHOLD);
		fp.findFreuqentMap(transactions, THRESHOLD);
		Map<ItemSet, Integer> frequentMap = fp.getFrequentMap();
		System.out.println(frequentMap);
		/*ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6 ));
		al.add(0, 1);
		System.out.println(al);*/
	}
}
