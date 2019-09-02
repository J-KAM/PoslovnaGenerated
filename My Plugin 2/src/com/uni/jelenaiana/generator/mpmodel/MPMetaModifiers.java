package com.uni.jelenaiana.generator.mpmodel;

public class MPMetaModifiers {
	
	private Boolean isFinal;
	private Boolean isAbstract;
	private Boolean isStatic;
	
	public MPMetaModifiers(Boolean isFinal, Boolean isAbstract, Boolean isStatic) {
		super();
		this.isFinal = isFinal;
		this.isAbstract = isAbstract;
		this.isStatic = isStatic;
	}

	public Boolean isFinal() {
		return isFinal;
	}

	public void setFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public Boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public Boolean isStatic() {
		return isStatic;
	}

	public void setStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}
	
}
