package org.qin.datamining.decesiontree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.qin.datamining.classifier.Attribute;
import org.qin.datamining.classifier.DataSet;

public class GainMethod implements AttriSelectMethod {
	
	/*private class ComputePair {
		//标记某一个值分支的计数
		public final int count;
		//表示这个值分支
		public final List<Float> probabilities;
		
		public ComputePair(int count, List<Float> probabilities) {
			this.count = count;
			this.probabilities = probabilities;
		}
	}*/

	@Override
	public Attribute selectMethod(DataSet data, List<Attribute> toHandledAttries) {
		Attribute selectedAttri = null;
		float info = getEntropy(data);
		float bestGain = Float.MIN_NORMAL;
		for(Attribute attri : toHandledAttries) {
			float gain = info - getAttriEntropy(data, attri);
			if(gain > bestGain) {
				bestGain = gain;
				selectedAttri = new Attribute(attri);
			}
		}		
		return selectedAttri;
	}
	
	private float getEntropy(DataSet data) {
		Collection<Integer> counts = data.getClassCount().values();
		float size = data.size();
		Collection<Float> probabilities = new ArrayList<Float>();
		for(Integer count : counts) {
			probabilities.add(count/size);
		}
		return getEntropy(probabilities);
	}
	
	private float getEntropy(Collection<Float> probabilities) {
		float result = 0;
		for(Float p : probabilities) {
			result += p * (Math.log10(p)/Math.log10(2));
		}
		result = -result;
		return result;
	}
	
	private float getAttriEntropy(DataSet data, Attribute attri) {
		//Collection<ComputePair> computePairs = getComputePairs(data, attri);
		float result = 0.0f;
		Map<String, DataSet> childDataMap = data.getChildDataMap(attri);
		for(String childName : childDataMap.keySet()) {
			DataSet childData = childDataMap.get(childName);
			result += childData.size() / data.size() * getEntropy(childData);
		}
		return result;
	}

	/*private Collection<ComputePair> getComputePairs(DataSet data,
			Attribute attri) {
		Collection<ComputePair> computePairs = new ArrayList<ComputePair>();
		
		return null;
	}*/
	
}
