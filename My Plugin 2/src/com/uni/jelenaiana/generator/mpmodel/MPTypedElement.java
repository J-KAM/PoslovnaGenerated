package com.uni.jelenaiana.generator.mpmodel;

public class MPTypedElement extends MPNamedElement {
	
	private String type;
	
	public MPTypedElement(String name, String importPackage, String type) {
		super(name, importPackage);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
