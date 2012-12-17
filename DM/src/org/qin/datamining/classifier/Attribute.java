package org.qin.datamining.classifier;

import java.util.ArrayList;
import java.util.List;

public class Attribute {

	private int attriIndex = -1;

	public int getAttriIndex() {
		return attriIndex;
	}

	private String name = null;
	private List<String> discreteValues = new ArrayList<String>();

	public Attribute(String name, List<String> discreteValues, int attriIndex) {
		super();
		this.name = name;
		this.discreteValues = discreteValues;
		this.attriIndex = attriIndex;
	}

	public Attribute() {
		super();
	}

	public Attribute(Attribute other) {
		name = other.name;
		discreteValues.addAll(other.discreteValues);
		attriIndex = other.attriIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDiscreteValues() {
		return discreteValues;
	}

	public void setDiscreteValues(List<String> discreteValues) {
		this.discreteValues = discreteValues;
	}

	public String toString() {
		return getName() + " index " + getAttriIndex() + "  ";
	}
}
