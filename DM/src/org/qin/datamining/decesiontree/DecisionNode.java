package org.qin.datamining.decesiontree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.qin.datamining.classifier.Attribute;
import org.qin.datamining.classifier.DataSet;
import org.qin.datamining.classifier.Record;

public class DecisionNode {
	private DecisionNode parent = null;
	private DataSet data = null;
	private Map<String, DecisionNode> childMap = new HashMap<String, DecisionNode>();
	private AttriSelectMethod attriMethod = null;
	private List<Attribute> toHandledAttries = new ArrayList<Attribute>();
	private Attribute curAttri = null;
	
	public Attribute getCurAttri() {
		return curAttri;
	}

	public void removeHandledAttri(Attribute attri) {
		toHandledAttries.remove(attri);
	}
	
	public List<Attribute> getToHandledAttries() {
		return toHandledAttries;
	}

	public void setToHandledAttries(List<Attribute> toHandledAttries) {
		this.toHandledAttries = toHandledAttries;
	}
	public DecisionNode(DecisionNode parent, DataSet data) {
		this(data);
		this.data = data;
		initAttri();
		initChildMap();
	}
	public DecisionNode(DataSet data) {
		super();
		this.data = data;
		initAttri();
		initChildMap();
	}
	
	public void setAttriMethod(AttriSelectMethod attriMethod) {
		this.attriMethod = attriMethod;
	}
	
	private DecisionNode initChildNode(Attribute dividingAttri) {
		DecisionNode child = new DecisionNode();
		child.setParent(this);
		List<Attribute> childToHanledAttries = new ArrayList<Attribute>(toHandledAttries);
		childToHanledAttries.remove(dividingAttri);
		child.setAttriMethod(attriMethod);
		child.setToHandledAttries(childToHanledAttries);
		return child;
	}
	private void initChildMap() {
		
		
		if(getClassLabel() != null)
			return;	
//System.out.println(toHandledAttries);
//System.out.println(dividingAttri);
		Attribute dividingAttri = curAttri;
		if(dividingAttri == null)
			return;
		List<String> attriDiscreteValues =  dividingAttri.getDiscreteValues(); 
		for(String childName : attriDiscreteValues) {			
			childMap.put(childName, initChildNode(dividingAttri));
		}
		/*for(Record record : data.getRecords()) {
			String attriValue = record.getAttributeValue(dividingAttri);
			childMap.get(attriValue).getData().addRecords(record);
		}*/
		Map<String, DataSet> childDataMap = data.getChildDataMap(dividingAttri);
		for(String childName : childMap.keySet()) {
			DecisionNode child = childMap.get(childName);
			child.setData(childDataMap.get(childName));
			child.initAttri();
			child.initChildMap();
		}
	}
	public DecisionNode() {
		super();
	}

	public DecisionNode(DataSet data, GainMethod gainMethod) {
		this.data = data;
		this.attriMethod = gainMethod;
		initChildMap();
	}

	public DecisionNode(DataSet data, GainMethod gainMethod,
			List<Attribute> attributes) {
		this.data = data;
		this.attriMethod = gainMethod;
		this.toHandledAttries.addAll(attributes);
		initAttri();
		initChildMap();
	}

	public DecisionNode getParent() {
		return parent;
	}
	public void setParent(DecisionNode parent) {
		this.parent = parent;
	}
	public DataSet getData() {
		return data;
	}
	public void setData(DataSet data) {
		this.data = data;
	}
	
	public boolean isLeafNode() {
		return false;
	}
	
	public DecisionNode getNextDecisionNode(Record record) {
		String childName = record.getAttributeValue(curAttri);
		return childMap.get(childName);
	}
	
	public String getClassLabel() {
		if(data.isUniqueClass())
			return data.getRecords().get(0).getClassName();
		/*if(data.getAttributes().isEmpty())
			return data.getMajorityClass();*/
		if(data.getRecords().isEmpty())
			return getParent().getData().getMajorityClass();
		if(toHandledAttries.isEmpty())
			return data.getMajorityClass();
		if(curAttri == null)
			return data.getMajorityClass();
		return null;
	}
	
	public String toString() {
		
		return toString(1);
	}
	
	public String toString(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for(int j = 0; j < i ; j++) {
			sb.append("+");
		}
		if(curAttri != null) 
			sb.append(curAttri.toString());
		for(String childName : childMap.keySet()) {
			sb.append(childMap.get(childName).toString(i + 1));
		}
		return sb.toString();
	}
	
	private void initAttri(){
		this.curAttri = attriMethod.selectMethod(data, toHandledAttries);
	}
}
