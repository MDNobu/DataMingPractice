package org.qin.datamining.classifier.naivebayesian;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.qin.datamining.classifier.AbstractClassifier;
import org.qin.datamining.classifier.Attribute;
import org.qin.datamining.classifier.DataSet;
import org.qin.datamining.classifier.Record;

public class NaiveBayesian extends AbstractClassifier {
	
	private DataSet data;

	private NaiveBayesian(DataSet data) {
		this.data = data;
		this.classLabels = data.getClasses();
	}

	public static NaiveBayesian trainData(DataSet data) {		
		return new NaiveBayesian(data);
	}

	public List<String> predict(DataSet testData) {
		List<String> predicts = new ArrayList<String>();
		for(Record record : testData.getRecords()) {
			predicts.add(predict(record));
		}
		return predicts;
	}
	
	public String predict(Record record) {
		Map<String, DataSet> classLabeledSubDataMap = data.getClassLabeledSubDataMap();
		String bestClassLabel = null;
		float bestCompute = Float.NEGATIVE_INFINITY;
		for(String className : classLabeledSubDataMap.keySet()) {			
			//classOverallProbabilities.put(className, classCount/data.size());
			//float a =  classLabeledSubDataMap.get(className).size() ;
			//float b = data.size();
			float classProbab = (float)classLabeledSubDataMap.get(className).size() / data.size();
			float a = computeRecordProbab(record, classLabeledSubDataMap.get(className));
			float curCompute = computeRecordProbab(record, classLabeledSubDataMap.get(className)) * classProbab;
			if(curCompute > bestCompute) {
				bestCompute = curCompute;
				bestClassLabel = className;
			}
		}
		return bestClassLabel;
	}

	private float computeRecordProbab(Record record, DataSet data) {
		// TODO Auto-generated method stub
		float result = 1;
		for(Attribute attr : data.getAttributes()) {
			Map<String, Integer> attriCount = data.getAttriCount(attr);
			result *= (float)attriCount.get(record.getAttributeValue(attr)) / data.size();
		}
		return result;
	}
	
}
