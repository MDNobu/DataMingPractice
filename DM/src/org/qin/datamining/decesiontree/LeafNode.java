package org.qin.datamining.decesiontree;

import org.qin.datamining.classifier.DataSet;

public class LeafNode extends DecisionNode {

	String classLabel = null;

	public LeafNode() {
		super();
	}

	public LeafNode(DecisionNode parent, DataSet data) {
		super(parent, data);
	}

	public LeafNode(DataSet data) {
		super(data);
	}
	
	public String getUniClassLabel() {
		return classLabel;
	}
	
}
