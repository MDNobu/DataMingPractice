package org.qin.datamining.fqm;

import java.util.ArrayList;
import java.util.List;

public class FNode {
	
	private String id = "";
	private int supCount = 0;
	
	private FNode parentNode;
	private List<FNode> childrenNode = new ArrayList<FNode>();
	
	public FNode(String itemName, int supCount) {
		this.id = itemName;
		this.supCount = supCount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String itemName) {
		this.id = itemName;
	}
	public int getSupCount() {
		return supCount;
	}
	public void setSupCount(int supCount) {
		this.supCount = supCount;
	}
	public FNode getParentNode() {
		return parentNode;
	}
	public void setParentNode(FNode parentNode) {
		this.parentNode = parentNode;
	}
	public List<FNode> getChildrenNode() {
		return childrenNode;
	}
	public void setChildrenNode(List<FNode> childrenNode) {
		this.childrenNode = childrenNode;
	}
	
	public FNode getChildById(String id) {
		
		for(FNode child : childrenNode) {
			if(child.getId().equals(id))
				return child;
		}		
		return null;
	}
	
	public void increase() {
		supCount++;
		return;
	}
	
	public void addChild(FNode child) {
		childrenNode.add(child);
		return;
	}
	
	public List<String> getParents() {
		List<String> parents = new ArrayList<String>();
		if(getId() == "null")
			return parents;
		FNode parent = getParentNode();
		while(parent.getId() != "null") {			
			parents.add(parent.getId());
			parent = parent.getParentNode();
		}		
		return parents;
	}
}
