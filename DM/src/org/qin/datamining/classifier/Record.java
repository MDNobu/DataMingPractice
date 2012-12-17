package org.qin.datamining.classifier;

import java.util.ArrayList;
import java.util.List;

public class Record {
	private List<String> attributeValues = new ArrayList<String>();
	public List<String> getAttributeValues() {
		return attributeValues;
	}

	private String className = null;

	public Record(List<String> attributes, String className) {
		super();
		this.attributeValues = attributes;
		this.className = className;
	}

	public String getClassName() {
		return className;
	}
	
	public String getAttributeValue(Attribute attri) {
		return attributeValues.get(attri.getAttriIndex());
	}
	
	public String toString() {
		return "content:" +attributeValues.toString() + "  classLabel:" + className;
	}
}
