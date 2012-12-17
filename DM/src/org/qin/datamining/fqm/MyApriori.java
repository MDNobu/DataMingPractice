package org.qin.datamining.fqm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyApriori extends AbstractDMAssociate{

	@Override
	public void findFrequentItemSets(Map<String, List<String>> transactions,
			int threshold) {
		//得到频繁一项
		Map<Set<String>, Integer> singleFrequentMap = new LinkedHashMap<Set<String>, Integer>();
		for(String id : transactions.keySet()) {
			for(String transaction : transactions.get(id)) {
				Set<String> s = new TreeSet<String>(Arrays.asList(transaction));
				Integer count = singleFrequentMap.get(s);
				Integer newCount = count==null?1:(count + 1);
				singleFrequentMap.put(s, newCount);
			}			
		}

		unionFrequentMap(singleFrequentMap);
System.out.println(frequentMap);
		Map<Set<String>, Integer> lastFrequentMap = singleFrequentMap;
		while(!lastFrequentMap.isEmpty()) {
			Set<Set<String>> candidates = getCandaidates(lastFrequentMap);
			lastFrequentMap.clear();
			for(Set<String> candidate : candidates) {
				lastFrequentMap.put(candidate, 0);
			}
			for(Set<String> candidate : candidates) {
				for(String s : transactions.keySet()) {
					if(transactions.get(s).containsAll(candidate)) {
						lastFrequentMap.put(candidate, lastFrequentMap.get(candidate) + 1);
					}						
				}
			}
			
			Map<Set<String>, Integer> tmpMap = new LinkedHashMap<Set<String>, Integer>(lastFrequentMap);
			for(Set<String> candidate : lastFrequentMap.keySet()) {
				if(lastFrequentMap.get(candidate) < threshold) 
					tmpMap.remove(candidate);
			}
			lastFrequentMap = tmpMap;
			unionFrequentMap(lastFrequentMap);
		}
		
	}
	
	public Set<Set<String>> getCandaidates(Map<Set<String>, Integer> frequentMap) {
		Set<Set<String>> candidates = new TreeSet<Set<String>>();
		for(Set<String> a1 : frequentMap.keySet()) {
			for(Set<String> a2 : frequentMap.keySet()) {
				if(hasOnlyDiffItem(a1, a2)) {
					Set<String> candidate = new TreeSet<String>(a1);
					candidate.addAll(a2);
					if(isValidCandidate(candidate, frequentMap.keySet())) {
						candidates.add(candidate);
					}
				}
			}
		}
		return candidates;
	}
	
	private boolean isValidCandidate(Set<String> kItem, Set<Set<String>> kmItemSets) {
		
		for(String s : kItem) {
			Set<String> item = new TreeSet<String>(kItem);
			item.remove(s);
			if(! kmItemSets.contains(item)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hasOnlyDiffItem(Set<String> a, Set<String> b) {
		
		int diffCount = 0;
		for(String sa: a) {
			for(String sb : b)
				if(!sa.equals(sb))
					diffCount++;
		}
		if(diffCount == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	private void unionFrequentMap(Map<Set<String>, Integer> iMap) {
		for(Set<String> itemSet : iMap.keySet()) {
			Integer count = frequentMap.get(itemSet);
			int toAdd = iMap.get(itemSet);
			int newCount = (count==null)?toAdd:(count + toAdd);
			frequentMap.put(itemSet, newCount);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, List<String>> transactions = new HashMap<String, List<String>>();
		
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while((line=bf.readLine()) != null) {
			String[] eles = line.split("\\W+");
			List<String> trans = new ArrayList<String>();
			for(int i = 1; i < eles.length; i++) {
				trans.add(eles[i]);
			}
			transactions.put(eles[0], trans);
		}
System.out.println(transactions);
		MyApriori my = new MyApriori();
		my.findFrequentItemSets(transactions, 2);
System.out.println(my.frequentMap);
	}
}
