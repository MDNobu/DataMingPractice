package org.qin.datamining.classifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClassifierIO {
	
	
	public static void printUserage() {
		System.out.println("\nUsage: java DecisionTreeAl <run mode> <trainFile> <testFile> <tuneFile>");
		System.out.println("");
	}

	public static DataSet fillDataSet(String fileName) {
		DataSet result = new DataSet();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			int attriCounter = -1;
			while((line = reader.readLine()) != null) {
				//根据行首处理每行
				if(line.equals("") || line.matches("^\\s*//.*$")) 
					continue;
				if(line.startsWith("%%")) {
					String[] classNames = line.substring(line.indexOf(",")+1).split(",");
					List<String> classes = new ArrayList<String>(Arrays.asList(classNames));
					result.addClasses(classes);
					continue;
				}
				if(line.startsWith("##")) {
					++attriCounter;
					result.addAttribute(handleAttriLine(line.substring(line.indexOf(",") + 1), attriCounter));
					continue;
				}
				result.addRecords(handleRecordLine(line));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	private static Attribute handleAttriLine(String line, int attriCounter) {
		String[] values = line.split(",");
		String name = values[0];
		List<String> discreteValues = new ArrayList<String>();
		discreteValues.addAll(Arrays.asList(values));
		discreteValues.remove(0);
		return new Attribute(name, discreteValues, attriCounter);
	}
	
	private static Record handleRecordLine(String line) {		
		String[] values = line.split(",");
		String className = values[values.length-1];
		List<String> attributeValues = new ArrayList<String>(Arrays.asList(values));
		attributeValues.remove(className);
		return new Record(attributeValues, className);
	}
}
