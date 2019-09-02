package com.uni.jelenaiana.analyzer;

import java.util.Iterator;
import java.util.List;

import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Enumeration;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.EnumerationLiteral;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.uni.jelenaiana.generator.mpmodel.MPClass;
import com.uni.jelenaiana.generator.mpmodel.MPEnumeration;
import com.uni.jelenaiana.generator.mpmodel.MPMetaModifiers;
import com.uni.jelenaiana.generator.mpmodel.MPMethod;
import com.uni.jelenaiana.generator.mpmodel.MPModel;
import com.uni.jelenaiana.generator.mpmodel.MPParameter;
import com.uni.jelenaiana.generator.mpmodel.MPProperty;
import com.uni.jelenaiana.generator.mpmodel.MPTypedElement;
import com.uni.jelenaiana.main.ConfigurationError;

public class MPModelAnalyzer {

	public void processModel(Package pack) throws ConfigurationError, AnalyzeException {
		
		if (pack.getName() == null) throw  
		new AnalyzeException("Packages must have names!");
		
		if(pack.hasOwnedElement()) {
			for (Iterator<Element> it = pack.getOwnedElement().iterator(); it.hasNext();) {
				Element ownedElement = it.next();
				
				if(ownedElement instanceof Enumeration) {
					Enumeration enumeration = (Enumeration)ownedElement;
					MPEnumeration mpEnum = getEnumData(enumeration);
					MPModel.getInstance().getEnumerations().add(mpEnum);
				
				} else if (ownedElement instanceof Class) {	
					Class cl = (Class)ownedElement;
					MPClass mpClass = getClassData(cl);
					MPModel.getInstance().getClasses().add(mpClass);
				} 
			}
		}
	}
	
	private MPEnumeration getEnumData(Enumeration enumeration) throws AnalyzeException {
		if (enumeration.getName() == null) 
			throw new AnalyzeException("Enumerations must have names!");
		
		String name = enumeration.getName();
		MPEnumeration newEnum = new MPEnumeration(name, "model.enums." + name);
		for(EnumerationLiteral literal : enumeration.getOwnedLiteral()) {
			newEnum.addValue(literal.getName());
		}
		
		return newEnum;	
	}
	
	private MPClass getClassData(Class cl) throws AnalyzeException {
		if (cl.getName() == null) 
			throw new AnalyzeException("Classes must have names!");
		
		MPMetaModifiers metaModifiers = new MPMetaModifiers(cl.isLeaf(), cl.isAbstract(), null);
	
		String className = cl.getName();
		String parentName = "";
		if(cl.getSuperClass().iterator().hasNext()) {
			Class parentClass = cl.getSuperClass().iterator().next();
			parentName = parentClass.getName();
		}
		
		MPClass mpClass = new MPClass(className, "model." + className, cl.getVisibility().toString(), parentName, metaModifiers);
		//add properties
		for(Property property : cl.getOwnedAttribute()) {
			MPProperty mpProperty = getPropertyData(property);
			if(mpProperty != null) {
				mpClass.addProperty(mpProperty);
			}
		}
		
		//add methods
		for(Operation operation : cl.getOwnedOperation()) {
			MPMethod mpMethod = getMethodData(operation);
			if(mpMethod != null) {
				mpClass.addMethod(mpMethod);
			}
		}
		return mpClass;
	}
	
	private MPProperty getPropertyData(Property property) throws AnalyzeException {
		if (property.getName() == null) 
			throw new AnalyzeException("Properties must have names!");

		String propertyName = property.getName();
		String visibility = property.getVisibility().toString();	
		String dataType = property.getType().getName();
	
		Stereotype classStereotype = StereotypesHelper.getAppliedStereotypeByString(property, "MPNamedElement");
		List<?> showPropertiesList = StereotypesHelper.getStereotypePropertyValue(property, classStereotype,"package");
		String importPackage = showPropertiesList.size() == 1 ? showPropertiesList.get(0).toString() : "";

		int lowerLimit = property.getLower();
		int upperLimit = property.getUpper();
		
		boolean isEnum = importPackage.contains(".enums.");
		boolean isNullable = lowerLimit == 0;
		
		classStereotype = StereotypesHelper.getAppliedStereotypeByString(property, "MPProperty");
		showPropertiesList = StereotypesHelper.getStereotypePropertyValue(property, classStereotype,"isPersistant");
		Boolean isPersistant = showPropertiesList.size() == 1 ? Boolean.valueOf(showPropertiesList.get(0).toString()) : null;
			
		MPProperty mpProperty = new MPProperty(propertyName, dataType, importPackage, visibility, property.isID(), isEnum, isPersistant,
				isNullable, property.isUnique(), lowerLimit, upperLimit);
		return mpProperty;
	}
	
	private MPMethod getMethodData(Operation operation) throws AnalyzeException {
		if (operation.getName() == null) 
			throw new AnalyzeException("Methods must have names!");
			
		Parameter returnParameter = ModelHelper.getReturnParameter(operation);
		MPTypedElement returnType = new MPTypedElement("", "", returnParameter.getType().getName());
		
		MPMetaModifiers metaModifiers = new MPMetaModifiers(operation.isLeaf(), operation.isAbstract(), operation.isStatic());		
		MPMethod mpMethod = new MPMethod(operation.getName(), "", operation.getVisibility().toString(), returnType, metaModifiers);
		
		List<Parameter> inParameters = ModelHelper.getParameters(operation);
		for(Parameter inParameter : inParameters) {
			mpMethod.addParameter(getParameterData(inParameter));
		}
		
		return mpMethod;
	}
	
	private MPParameter getParameterData(Parameter parameter) throws AnalyzeException {
		if (parameter.getName() == null) 
			throw new AnalyzeException("Parameters must have names!");
		
		Stereotype classStereotype = StereotypesHelper.getAppliedStereotypeByString(parameter, "MPNamedElement");
		List<?> showPropertiesList = StereotypesHelper.getStereotypePropertyValue(parameter, classStereotype, "package");
		String importPackage = showPropertiesList.size() == 1 ? showPropertiesList.get(0).toString() : "";
		
		MPParameter mpParameter = new MPParameter(parameter.getName(), parameter.getType().getName(), importPackage);
		return mpParameter;
	}
	
}
