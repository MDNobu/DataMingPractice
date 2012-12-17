package org.qin.datamining.classifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSet {

	private List<Attribute> attributes = new ArrayList<Attribute>();
	private List<Record> records = new ArrayList<Record>();
	private List<String> classes = new ArrayList<String>();
	
	public DataSet() {}
	
	public DataSet(DataSet other) {
		attributes = other.attributes;
		classes = other.classes;
	}

	public DataSet(List<Attribute> attributes, List<Record> records,
			List<String> classes) {
		super();
		this.attributes = attributes;
		this.records = records;
		this.classes = classes;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
	};
	
	public void addClasses(List<String> classes) {
		this.classes.addAll(classes);
	}
	
	public void addAttribute(Attribute attri) {
		attributes.add(attri); 
	}

	public void addRecords(Record handleRecordLine) {
		// TODO Auto-generated method stub
		records.add(handleRecordLine);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("classes:\t");
		for(String className : classes) {
			sb.append(className + "   ");
		}
		sb.append("\nattributes:\t");
		for(Attribute attribute : attributes) {
			sb.append(attribute.toString());
		}
		sb.append("\nrecords count:\t");
		sb.append(size() + "\n");
		sb.append("record1 : \t");
		sb.append(records.get(0));
		return sb.toString();
	}
	
	public int size() {
		return records.size();
	}
	
	public boolean isUniqueClass() {
		return getClassCount().size()==1;
	}
	
	public String getMajorityClass() {
		Map<String, Integer> classCount = getClassCount();
		String majority = null;
		int maxCount = Integer.MIN_VALUE;
		for(String className : classCount.keySet()) {
			if(classCount.get(className) > maxCount) {
				maxCount = classCount.get(className);
				majority = className;
			}
		}
		return majority;
	}
	
	public Map<String, Integer> getClassCount() {
		Map<String, Integer> classCount = new HashMap<String, Integer>();
		for(Record record : records) {
			String className = record.getClassName();
			Integer counter = classCount.get(className);
			if(counter== null) {
				classCount.put(className, 1);
			} else {
				classCount.put(className, counter +1);
			}
		}
		return classCount;
	}
	
	public DataSet getSubDataSetByAttribueValue(Attribute attri, String value) {
		DataSet result = new DataSet();
		result.setClasses(classes);
		result.setAttributes(attributes);
		for(Record record : records) {
			String recordAttriValue = record.getAttributeValues().get(attri.getAttriIndex());
			if(recordAttriValue.equals(value)) 
				result.addRecords(record);
		}
		return result;
	}
	
	public Map<String, DataSet> getChildDataMap(Attribute attri) {
		Map<String, DataSet> childDataMap = new HashMap<String, DataSet>();
		//List<String> attriDiscreteValues = attri.getDiscreteValues();
		for(Record record : getRecords()) {
			String childName = record.getAttributeValue(attri);
			DataSet childData = childDataMap.get(childName);
			if(childData == null) {
				childData = new DataSet(this);
				childDataMap.put(childName, childData);
			}
			childData.addRecords(record);
		}
		return childDataMap;
	}
	
	public Map<String, DataSet> getClassLabeledSubDataMap() {
		Map<String, DataSet> childDataMap = new HashMap<String, DataSet>();
		//List<String> attriDiscreteValues = attri.getDiscreteValues();
		for(Record record : getRecords()) {
			String childName = record.getClassName();
			DataSet childData = childDataMap.get(childName);
			if(childData == null) {
				childData = new DataSet(this);
				childDataMap.put(childName, childData);
			}
			childData.addRecords(record);
		}
		return childDataMap;
	}
	
	public Map<String, Integer> getAttriCount(Attribute attri) {
		Map<String, Integer> classCount = new HashMap<String, Integer>();
		for(String attriValue : attri.getDiscreteValues()) {
			classCount.put(attriValue, 0);
		}
		for(Record record : records) {
			String attriValue = record.getAttributeValue(attri);
			Integer counter = classCount.get(attriValue);			
			classCount.put(attriValue, counter +1);			
		}
		return classCount;
	}
}
