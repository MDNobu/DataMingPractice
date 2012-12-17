package org.qin.datamining.fqm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DMIOUtils {

	public static Map<String, List<String>> readMap(String[] args) throws IOException {
		Map<String, List<String>> transactions = new HashMap<String, List<String>>();

		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = bf.readLine()) != null) {
			String[] eles = line.split("\\W+");
			List<String> trans = new ArrayList<String>();
			for (int i = 1; i < eles.length; i++) {
				trans.add(eles[i]);
			}
			transactions.put(eles[0], trans);
		}
		return transactions;
	}
	
	public static Map<String, List<String>> readMapWithoutID(String filename){
		Map<String, List<String>> transactions = new HashMap<String, List<String>>();

		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(filename));
			String line = null;
			int i = 0;
			while ((line = bf.readLine()) != null) {
				String[] eles = line.split("\\s+");
				List<String> trans = new ArrayList<String>();
				trans.addAll(Arrays.asList(eles));
				transactions.put(String.valueOf(i), trans);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return transactions;
	}
	


	public static void printMap(Map<String, List<String>> transactions) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for(String id : transactions.keySet()) {
			sb.append(id + ":");
			sb.append(transactions.get(id).toString() + "\n");
		}		
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	public static Map<ItemSet, Integer> getSingleFrequentMap(Map<String, List<String>> transactions, int threshold) {
		return getSingleFrequentMap(transactions.values(), threshold);
	}
	
	public static Map<ItemSet, Integer> getSingleFrequentMap(Collection<List<String>>  transactions, int threshold) {
		Map<ItemSet, Integer> singleCandi = new TreeMap<ItemSet, Integer>();
		for (List<String> s : transactions) {
			for (String singleEle : s) {
				ItemSet singleItemSet = new ItemSet();
				singleItemSet.add(singleEle);
				Integer supCount = singleCandi.get(singleItemSet);
				singleCandi.put(singleItemSet, supCount == null ? 1
						: supCount + 1);
			}
		}
		Map<ItemSet, Integer> singleFrequentMap = new TreeMap<ItemSet, Integer>();
		for (ItemSet singleItemSet : singleCandi.keySet()) {
			if (singleCandi.get(singleItemSet) >= threshold) {
				singleFrequentMap.put(singleItemSet,
						singleCandi.get(singleItemSet));
			}
		}
		return singleFrequentMap;
	}
}