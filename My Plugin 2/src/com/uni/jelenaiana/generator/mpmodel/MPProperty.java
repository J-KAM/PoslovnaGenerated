package com.uni.jelenaiana.generator.mpmodel;

public class MPProperty extends MPTypedElement {
	
	private String visibility;
	private Boolean isKey;
	private Boolean isEnum;
	private Boolean isPersistant;
	private Boolean isNullable;
	private Boolean isUnique;
	private Integer lower;
	private Integer upper;
	
	public MPProperty(String name, String type, String typePackage, String visibility, Boolean isKey, Boolean isEnum,
			Boolean isPersistant, Boolean isNullable, Boolean isUnique, Integer lower, Integer upper) {
		super(name, type, typePackage);
		this.visibility = visibility;
		this.isKey = isKey;
		this.isEnum = isEnum;
		this.isPersistant = isPersistant;
		this.isNullable = isNullable;
		this.isUnique = isUnique;
		this.lower = lower;
		this.upper = upper;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Boolean isKey() {
		return isKey;
	}

	public void setKey(Boolean isKey) {
		this.isKey = isKey;
	}

	public Boolean isEnum() {
		return isEnum;
	}

	public void setEnum(Boolean isEnum) {
		this.isEnum = isEnum;
	}

	public Boolean isPersistant() {
		return isPersistant;
	}

	public void setPersistant(Boolean isPersistant) {
		this.isPersistant = isPersistant;
	}

	public Boolean isNullable() {
		return isNullable;
	}

	public void setNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}

	public Boolean isUnique() {
		return isUnique;
	}

	public void setUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}
	
	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}
	
}
