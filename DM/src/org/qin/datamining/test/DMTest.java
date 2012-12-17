package org.qin.datamining.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.qin.datamining.fqm.FPTree.Tuple;

public class DMTest {

	@Test
	public void test() {

        List<Tuple> tuples = new ArrayList<Tuple>();
        Collections.sort(tuples, new Comparator<Tuple>(){
			@Override
			public int compare(Tuple a, Tuple b) {
				
				return a.compareTo(b);
			}        	
        });
	}

}
