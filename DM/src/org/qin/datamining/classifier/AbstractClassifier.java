package org.qin.datamining.classifier;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractClassifier {
	
	protected List<String> classLabels = new ArrayList<String>();
	abstract protected List<String> predict(DataSet data);
	
}
