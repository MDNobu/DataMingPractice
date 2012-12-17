package org.qin.datamining.decesiontree;

import java.util.List;

import org.qin.datamining.classifier.DataSet;
import org.qin.datamining.classifier.ClassifierIO;

public class DecionsionTreeAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String trainFileName = args[0];
		String testFileName = args[1];
		DataSet trainDataSet = ClassifierIO.fillDataSet(trainFileName);
		System.out.println(trainDataSet);
		DecisionTree decisionTree = DecisionTree.trainData(trainDataSet);
		System.out.println(decisionTree);
		DataSet testDataSet = ClassifierIO.fillDataSet(testFileName);
		List<String> predictions = decisionTree.predict(testDataSet);
		System.out.println(predictions);
		
	}

}
