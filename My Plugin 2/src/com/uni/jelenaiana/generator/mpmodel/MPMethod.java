package com.uni.jelenaiana.generator.mpmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MPMethod extends MPNamedElement {
	
	private String visibility;
	private MPTypedElement returnType;
	private MPMetaModifiers metaModifiers;
	private List<MPParameter> parameters = new ArrayList<>();
	
	public MPMethod(String name, String importPackage, String visibility, MPTypedElement returnType, MPMetaModifiers metaModifiers) {
		super(name, importPackage);
		this.visibility = visibility;
		this.returnType = returnType;
		this.metaModifiers = metaModifiers;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public MPTypedElement getReturnType() {
		return returnType;
	}

	public void setReturnType(MPTypedElement returnType) {
		this.returnType = returnType;
	}

	public MPMetaModifiers getMetaModifiers() {
		return metaModifiers;
	}

	public void setMetaModifiers(MPMetaModifiers metaModifiers) {
		this.metaModifiers = metaModifiers;
	}

	public List<MPParameter> getParameters() {
		return parameters;
	}
		
	public Iterator<MPParameter> getParameterIterator(){
		return parameters.iterator();
	}
	
	public void addParameter(MPParameter parameter){
		parameters.add(parameter);		
	}
	
}
