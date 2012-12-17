package org.qin.datamining.decesiontree;

import java.util.ArrayList;
import java.util.List;

import org.qin.datamining.classifier.DataSet;
import org.qin.datamining.classifier.Record;

public class DecisionTree {

	private DecisionNode root = null;

	public DecisionTree(DecisionNode root) {
		super();
		this.root = root;
	}

	public DecisionNode getRoot() {
		return root;
	}

	public void setRoot(DecisionNode root) {
		this.root = root;
	}

	public static DecisionTree trainData(DataSet trainDataSet) {
		DecisionNode root = new DecisionNode(trainDataSet, new GainMethod(), trainDataSet.getAttributes());
//System.out.println(trainDataSet.getAttributes());
		//root.getToHandledAttries().addAll(trainDataSet.getAttributes());
		return new DecisionTree(root);
	}

	public List<String> predict(DataSet testDataSet) {
		List<String> predicts = new ArrayList<String>();
		for(Record record : testDataSet.getRecords()) {
			DecisionNode cur = root;
			while(cur.getClassLabel() == null)
				cur = cur.getNextDecisionNode(record);
			String classLabel = cur.getClassLabel();
			predicts.add(classLabel);
		}
		return predicts;
	}

	public String toString() {
		return root.toString();
	}
}
