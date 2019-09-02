package com.uni.jelenaiana.generator.mpmodel;

import java.util.ArrayList;
import java.util.Iterator;

public class MPEnumeration extends MPNamedElement {
	
	private ArrayList<String> values = new ArrayList<String>();

	public MPEnumeration(String name, String importPackage) {
		super(name, importPackage);
	}

	public ArrayList<String> getValues() {
		return values;
	}
	
	public Iterator<String> getValuesIterator(){
		return values.iterator();
	}
	
	public void addValue(String value){
		values.add(value);		
	}

}
