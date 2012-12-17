package org.qin.datamining.fqm;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyAprioriV2 extends AbstractDMAssV2 {
	// 扫描数据得到，项集支持度计数
	private Map<ItemSet, Integer> scanDB(Set<ItemSet> candidates,
			Map<String, List<String>> transactions) {
		Map<ItemSet, Integer> result = new TreeMap<ItemSet, Integer>();
		for (String s : transactions.keySet()) {
			List<String> transaction = transactions.get(s);
			for (ItemSet itemSet : candidates) {
				if (transaction.containsAll(itemSet)) {
					Integer supCount = result.get(itemSet);
					result.put(itemSet, supCount == null ? 1 : supCount + 1);
				}
			}
		}
		Map<ItemSet, Integer> tmp = new TreeMap<ItemSet, Integer>(result);
		for (ItemSet itemSet : tmp.keySet()) {
			if (tmp.get(itemSet) < threshold) {
				result.remove(itemSet);
			}
		}
		return result;
	}

	@Override
	void findFreuqentMap(Map<String, List<String>> transactions, int threshold) {

		this.threshold = threshold;
		// 得到频繁一项集
		Map<ItemSet, Integer> singleCandi = new TreeMap<ItemSet, Integer>();
		for (String s : transactions.keySet()) {
			for (String singleEle : transactions.get(s)) {
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
		// System.out.println(singleFrequentMap);

		// 循环，直到最后最长的频繁项集表为空
		Map<ItemSet, Integer> lastFrequentMap = singleFrequentMap;
		while (!lastFrequentMap.isEmpty()) {
System.out.println(lastFrequentMap);
			frequentMap.putAll(lastFrequentMap);
			Set<ItemSet> candidates = getCandidates(lastFrequentMap);
			lastFrequentMap = scanDB(candidates, transactions);
		}
	}

	// 根据i-1频繁项集表得到候选项集
	private Set<ItemSet> getCandidates(Map<ItemSet, Integer> lastFrequentMap) {
		Set<ItemSet> result = new TreeSet<ItemSet>();
		for (ItemSet i : lastFrequentMap.keySet()) {
			for (ItemSet j : lastFrequentMap.keySet()) {
				if (i.hasOneDiff(j)) {
					ItemSet candidate = new ItemSet(i);
					candidate.addAll(j);
					if (isValid(candidate, lastFrequentMap)) {
						result.add(candidate);
					}
				}
			}
		}
		return result;
	}

	// 判断一个i项集是不是有效
	private boolean isValid(ItemSet candidate,
			Map<ItemSet, Integer> lastFrequentMap) {
		for (String item : candidate) {
			ItemSet subSet = new ItemSet(candidate);
			subSet.remove(item);
			if (!lastFrequentMap.keySet().contains(subSet))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		Map<String, List<String>> transactions = DMIOUtils.readMapWithoutID(args[0]);
//System.out.println(transactions);
		//DMIOUtils.printMap(transactions);
		// System.out.println(transactions);
		MyAprioriV2 my = new MyAprioriV2();
		long startTime = System.currentTimeMillis();
		my.findFreuqentMap(transactions, 10);
		long time = System.currentTimeMillis() - startTime;
		System.out.println("持续时间" + time);
		System.out.println(my.frequentMap);
		Map<ItemSet, Integer> maxMap = my.getMaxFrequentMap();
		System.out.println(maxMap);
		Map<ItemSet, Integer> closureMap = my.getClosuerFrequentMap();
		System.out.println(closureMap);
	}
}