package com.uni.jelenaiana.main;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.uni.jelenaiana.analyzer.ModelGenerator;

public class ActionEventHandler {
	
	private ModelGenerator gen = new ModelGenerator();

	public void handle(ActionEvent evt) {
		try {
			Project project = getProject();
			Package pack = getPackage(project);
			gen.generate(pack);
			
		} catch (ConfigurationError e) {
			JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogOwner(),
					e.getMessage());
		}
	}
	
	private Project getProject() throws ConfigurationError {
		Project project = Application.getInstance().getProject();
		if (project == null) throw new ConfigurationError("Please open a project first!");
		return project;
	}
	
	private Package getPackage(Project project) throws ConfigurationError {
		Package pack = project.getPrimaryModel();
		if (pack == null) throw new ConfigurationError("Please open a project first!");
		return pack;
	}
}