package org.qin.datamining.decesiontree;

import java.util.List;

import org.qin.datamining.classifier.Attribute;
import org.qin.datamining.classifier.DataSet;

public interface AttriSelectMethod {

	Attribute selectMethod(DataSet data, List<Attribute> toHandledAttries);
	
}
