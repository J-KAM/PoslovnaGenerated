package com.uni.jelenaiana.generator.mpmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MPClass extends MPNamedElement {
	
	private String visibility;
	
	private String parentName;
	
	private MPMetaModifiers metaModifiers;
	
	private List<MPProperty> properties = new ArrayList<MPProperty>();
	
	private List<MPMethod> methods = new ArrayList<>();
	
	public MPClass(String name, String importPackage, String visibility, String parentName,
			MPMetaModifiers metaModifiers, List<MPProperty> properties, List<MPMethod> methods) {
		super(name, importPackage);
		this.visibility = visibility;
		this.parentName = parentName;
		this.metaModifiers = metaModifiers;
		this.properties = properties;
		this.methods = methods;
	}
	
	public MPClass(String name, String importPackage, String visibility, String parentName, MPMetaModifiers metaModifiers) {
		super(name, importPackage);
		this.visibility = visibility;
		this.parentName = parentName;
		this.metaModifiers = metaModifiers;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public MPMetaModifiers getMetaModifiers() {
		return metaModifiers;
	}

	public void setMetaModifiers(MPMetaModifiers metaModifiers) {
		this.metaModifiers = metaModifiers;
	}

	public List<MPProperty> getProperties() {
		return properties;
	}
	
	public Iterator<MPProperty> getPropertyIterator(){
		return properties.iterator();
	}
	
	public void addProperty(MPProperty property){
		properties.add(property);		
	}
	
	public int getPropertyCount(){
		return properties.size();
	}

	public List<MPMethod> getMethods() {
		return methods;
	}
	
	public Iterator<MPMethod> getMethodIterator(){
		return methods.iterator();
	}
	
	public void addMethod(MPMethod method){
		methods.add(method);		
	}
	
	public int getMethodCount(){
		return methods.size();
	}
	
}
