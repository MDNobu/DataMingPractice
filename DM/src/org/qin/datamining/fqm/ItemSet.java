package org.qin.datamining.fqm;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ItemSet extends TreeSet<String> implements Comparable<ItemSet>{
	public ItemSet(ItemSet c) {
		super(c);			
	}
	public ItemSet() {
		super();
	}
	public boolean hasOneDiff(ItemSet other) {
		Set<String> tmp = new ItemSet(this);
		tmp.removeAll(other);
		return tmp.size()==1;
	}
	@Override
	public boolean equals(Object other) {
		ItemSet iother = null;
		if(other instanceof ItemSet) {
			iother = (ItemSet)other;
		}
		return compareTo(iother)==0?true:false;
	}
	@Override
	public int compareTo(ItemSet other) {
		if(size() < other.size()) {
			return -1;
		} else if (size() > other.size()) {
			return 1;
		}
		List<String> selfList = new LinkedList<String>(this);
		List<String> otherList = new LinkedList<String>(other);
		for(int i = 0; i < selfList.size(); i++) {
			if(!selfList.get(i).equals(otherList.get(i))) {
				return selfList.get(i).compareTo(otherList.get(i));
			}
		}
		return 0;
	}
}