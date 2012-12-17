package org.qin.datamining.fqm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDMAssociate {

	protected Map<Set<String>, Integer> frequentMap = new LinkedHashMap<Set<String>, Integer>();
	protected int threshold = 0;
	
	abstract public void findFrequentItemSets(Map<String, List<String>> transactions, int threshold) ;
	
	public Map<Set<String>, Integer> getFrequentMap() {
		return frequentMap;
	}
	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Set<String> itemSet : frequentMap.keySet()) {
			result.append(itemSet.toString() + "=" + frequentMap.get(itemSet) + "  ");
		}		
		return result.toString();
	}

	public Map<Set<String>, Integer> getMaxFrequentMap() {
		Map<Set<String>, Integer> maxFrequentMap = new LinkedHashMap<Set<String>, Integer>();
		for(Set<String> candidate : frequentMap.keySet()) {
			boolean isCandidate = true;
			for(Set<String> toCheck : frequentMap.keySet()) {
				if(!candidate.equals(toCheck) && toCheck.containsAll(candidate)) {
					isCandidate = false;
					break;
				}					
			}
			
			if(isCandidate) {
				maxFrequentMap.put(candidate, frequentMap.get(candidate));
			}
		}
		return maxFrequentMap;
	}
	
	public Map<Set<String>, Integer> getClosureFrequentMap() {
		Map<Set<String>, Integer> closureFrequentMap = new LinkedHashMap<Set<String>, Integer>();
		for(Set<String> candidate : frequentMap.keySet()) {
			boolean isCandidate = true;
			for(Set<String> toCheck : frequentMap.keySet()) {
				if(!candidate.equals(toCheck) && toCheck.containsAll(candidate)
						&& frequentMap.get(toCheck).equals(frequentMap.get(candidate))) {
					isCandidate = false;
					break;
				}					
			}
			
			if(isCandidate) {
				closureFrequentMap.put(candidate, frequentMap.get(candidate));
			}
		}
		return closureFrequentMap;
	}
}
