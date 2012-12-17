package org.qin.datamining.classifier;

import java.util.List;

import org.qin.datamining.classifier.naivebayesian.NaiveBayesian;

public class ClassifierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String trainFile = args[0];
		String testFile = args[1];
		DataSet trainData = ClassifierIO.fillDataSet(trainFile);
		DataSet testData = ClassifierIO.fillDataSet(testFile);
		AbstractClassifier classifier = NaiveBayesian.trainData(trainData);
		List<String> predicts = classifier.predict(testData);
System.out.println(predicts);
	}

}
