package org.qin.datamining.fqm;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class AbstractDMAssV2 {
	
	protected int threshold = 0;

	
	
	Map<ItemSet, Integer> frequentMap = new TreeMap<ItemSet, Integer>();
	
	abstract void findFreuqentMap(Map<String, List<String>> transactions, int threshold);
	
	//���ʼ���õĺ�������ʼ�����ڲ���Ƶ�����
	public Map<ItemSet, Integer> getFrequentMap() {
		return frequentMap;
	}
	
	//�õ����Ƶ���
	public Map<ItemSet, Integer> getMaxFrequentMap() {
		Set<ItemSet> allItemSet = frequentMap.keySet();
		Set<ItemSet> tmpItemSet = new TreeSet<ItemSet>(allItemSet);
		//�Ƴ�ĳһ���Ǳ��������Ӽ�����
		for(ItemSet i : allItemSet) {
			for(ItemSet j : allItemSet) {
				if(!i.equals(j) && i.containsAll(j)) {
					tmpItemSet.remove(j);
				}
			}
		}
		Map<ItemSet, Integer> maxFrequentMap = new TreeMap<ItemSet, Integer>();
		for(ItemSet is : tmpItemSet) {
			maxFrequentMap.put(is, frequentMap.get(is));
		}
		return maxFrequentMap;
	}
	
	public Map<ItemSet, Integer> getClosuerFrequentMap() {
		Set<ItemSet> allItemSet = frequentMap.keySet();
		Set<ItemSet> tmpItemSet = new TreeSet<ItemSet>(allItemSet);
		for(ItemSet i : allItemSet) {
			for(ItemSet j : allItemSet) {
				if(!i.equals(j) && i.containsAll(j) && frequentMap.get(i).equals(frequentMap.get(j))) {
					tmpItemSet.remove(j);
				}
			}
		}
		Map<ItemSet, Integer> maxFrequentMap = new TreeMap<ItemSet, Integer>();
		for(ItemSet is : tmpItemSet) {
			maxFrequentMap.put(is, frequentMap.get(is));
		}
		return maxFrequentMap;
	}
}
