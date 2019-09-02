package com.uni.jelenaiana.generator.mpmodel;

import java.util.ArrayList;
import java.util.List;

public class MPModel {
	
	private List<MPClass> classes = new ArrayList<MPClass>();
	private List<MPEnumeration> enumerations = new ArrayList<MPEnumeration>();
	private static MPModel model;

	private MPModel() {}
	
	public static MPModel getInstance() {
		if (model == null) {
			model = new MPModel();			
		}
		return model;
	}
	
	public List<MPClass> getClasses() {
		return classes;
	}
	public void setClasses(List<MPClass> classes) {
		this.classes = classes;
	}
	public List<MPEnumeration> getEnumerations() {
		return enumerations;
	}
	public void setEnumerations(List<MPEnumeration> enumerations) {
		this.enumerations = enumerations;
	}



}
