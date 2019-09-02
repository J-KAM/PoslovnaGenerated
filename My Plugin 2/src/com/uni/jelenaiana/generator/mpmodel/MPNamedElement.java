package com.uni.jelenaiana.generator.mpmodel;

/** Element - abstract ancestor for all model elements */

public abstract class MPNamedElement {
	
	private String name;
	
	private String importPackage;
	
	public MPNamedElement(String name, String importPackage) {
		this.name = name;
		this.importPackage = importPackage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean hasName() {
		return name != null;
	}

	public String getImportPackage() {
		return importPackage;
	}

	public void setImportPackage(String importPackage) {
		this.importPackage = importPackage;
	}
	
	public Boolean hasImportPackage() {
		return importPackage != null;
	}


}
