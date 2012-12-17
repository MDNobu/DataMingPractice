package org.qin.datamining.fqm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class FPTree extends AbstractDMAssV2 {

	public class Tuple implements Comparable<Tuple> {
		public final int supCount;
		public String id;
		private List<FNode> nodeList = new LinkedList<FNode>();

		public Tuple(String id, int supCount) {
			this.id = id;
			this.supCount = supCount;
		}

		public List<FNode> getNodeList() {
			return nodeList;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(id + " :");
			sb.append(supCount + " :");
			sb.append(nodeList + "\n");
			return sb.toString();
		}
		@Override
		public int compareTo(Tuple o) {
			if (this.supCount != o.supCount) {
				return this.supCount - o.supCount;
			} else {
				return this.id.compareTo(o.id);
			}
		}

	}
	//快速访问用的列表
	private ArrayList<Tuple> headerTable = new ArrayList<Tuple>();
	//头结点
	private FNode root = new FNode("null", 0) ;
	private int threshold;
	
	public FPTree(Map<String, List<String>> transactions, int threshold) {
		this(transactions.values(), threshold);
	}
	
	public FPTree(Collection<List<String>> transactions, int threshold) {
		this.threshold = threshold;
		Map<ItemSet, Integer> singleFrequentMap = DMIOUtils.getSingleFrequentMap(transactions, threshold);
		for (ItemSet item : singleFrequentMap.keySet()) {
			Tuple toInsert = new Tuple(item.first(),
					singleFrequentMap.get(item));
			/*int i;
			for (i = 0; i < accessList.size()
					&& toInsert.compareTo(accessList.get(i)) < 0; i++)
				;*/
			headerTable.add(toInsert);
		}
		 Collections.sort(headerTable, new Comparator<Tuple>(){
				@Override
				public int compare(Tuple a, Tuple b) {
					
					return b.compareTo(a);
				}        	
	        });
		//accessList.remove(0);
//System.out.println(headerTable);
		initTree(transactions, headerTable);
	}
	
	private void initTree(Collection<List<String>> transactions,
			ArrayList<Tuple> headerTable2) {
		sortTans(transactions, headerTable2);
		for(List<String> record : transactions) {
			insertRecord(record, root);
		}
	}	

	private void sortTans(Collection<List<String>> transactions,
			ArrayList<Tuple> headerTable2) {
		Comparator<String> tupleComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(getTupleById(o1) == null)
					return 1;
				if(getTupleById(o2) == null)
					return -1;				
				return headerTable.indexOf(getTupleById(o1)) - headerTable.indexOf(getTupleById(o2));
			}			
		};
		for(List<String> record : transactions) {
			for(String ele : new ArrayList<String>(record)) {
				if(getTupleById(ele) == null) {
					record.remove(ele);
				}
			}
			Collections.sort(record, tupleComparator);
		}
	
	}

	public Tuple getTupleById(String id) {
		for(Tuple ele : headerTable) {
			if(ele.id.equals(id))
				return ele;
		}
		return null;
	}
	
	private void insertRecord(List<String> record, FNode root) {
		LinkedList<String> linkRecord = new LinkedList<String>(record);
		String id =linkRecord.poll();
		if(id == null) 
			return;
		FNode child = root.getChildById(id);
		if(child == null) {
			child = new FNode(id, 1);
			child.setParentNode(root);
			root.addChild(child);
			getTupleById(id).getNodeList().add(child);
		} else {
			child.increase();
		}
		insertRecord(linkRecord, child);
	}

	private void combine(List<List<String>> transactions, ItemSet items, int threshold) {
		FPTree fp = new FPTree(transactions, threshold);
		List<Tuple> localHeaderTable = fp.getHeaderTable();
		if(localHeaderTable.isEmpty())
			return ;
		
		//倒序遍历头表，更新频繁项集表
		for(int i = localHeaderTable.size() - 1; i >= 0; i--) {
			
			//把现在处理的项目id与之前的连接之后加入频繁项集表
			Tuple curTuple = localHeaderTable.get(i);
			ItemSet newItems = new ItemSet(items);
			newItems.add(curTuple.id);
			frequentMap.put(newItems, curTuple.supCount);
System.out.println(frequentMap);			
			//得到新的事物集
			List<FNode> nodeList = curTuple.getNodeList();
			List<List<String>> newTransactions = new ArrayList<List<String>>();
			for(FNode node : nodeList) {
				List<String> parents = node.getParents();
				if(parents.isEmpty())
					continue;
				newTransactions.addAll(Collections.nCopies(node.getSupCount(), parents));
			}
			if(newTransactions.isEmpty())
				return;
			//用新的事物集和连接项更新频繁表
			combine(newTransactions, newItems, threshold);
		}
	}
	
	public void FPGrowth(List<List<String>> transactions, int threshold) {
		
		Map<ItemSet, Integer> singleFrequentMap = DMIOUtils.getSingleFrequentMap(transactions, threshold);
		frequentMap.putAll(singleFrequentMap);
		combine(transactions, new ItemSet(),  threshold);
	}

	public ArrayList<Tuple> getHeaderTable() {
		return headerTable;
	}

	@Override
	public void findFreuqentMap(Map<String, List<String>> transactions, int threshold) {
		
		FPGrowth(new ArrayList<List<String>>(transactions.values()), threshold);
	}

	
}
