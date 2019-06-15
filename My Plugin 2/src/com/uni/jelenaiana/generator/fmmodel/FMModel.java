package com.uni.jelenaiana.generator.fmmodel;

import java.util.ArrayList;
import java.util.List;

public class FMModel {
	
	private List<FMClass> classes = new ArrayList<FMClass>();
	private List<FMEnumeration> enumerations = new ArrayList<FMEnumeration>();
	

	private FMModel() {}
	
	private static FMModel model;
	
	public static FMModel getInstance() {
		if (model == null) {
			model = new FMModel();			
		}
		return model;
	}
	
	public List<FMClass> getClasses() {
		return classes;
	}
	public void setClasses(List<FMClass> classes) {
		this.classes = classes;
	}
	public List<FMEnumeration> getEnumerations() {
		return enumerations;
	}
	public void setEnumerations(List<FMEnumeration> enumerations) {
		this.enumerations = enumerations;
	}



}
