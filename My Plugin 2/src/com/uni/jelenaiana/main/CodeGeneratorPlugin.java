package com.uni.jelenaiana.main;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

public class CodeGeneratorPlugin extends Plugin {

	String pluginDir = null;

	public void init() {

		// Application.getInstance().getGUILog().showMessage("Show a popup the proper way !");
		Menu menu = new Menu();
		menu.register();

		// Application.getInstance().getGUILog().showMessage("Show a popup the proper
		// way !");

		// final ActionsConfiguratorsManager manager =
		// ActionsConfiguratorsManager.getInstance();

		// final MDAction action = new ExampleAction();
		// Adding action to main menu
		// manager.addMainMenuConfigurator(new MainMenuConfigurator(action));
		// Adding action to main toolbar
		// manager.addMainToolbarConfigurator(new MainToolbarConfigurator(action));

		// pluginDir = getDescriptor().getPluginDirectory().getPath();

		// Creating submenu in the MagicDraw main menu
		// ActionsConfiguratorsManager manager =
		// ActionsConfiguratorsManager.getInstance();
		// manager.addMainMenuConfigurator(new
		// MainMenuConfigurator(getSubmenuActions()));

		/**
		 * @Todo: load project options (@see myplugin.generator.options.ProjectOptions)
		 *        from ProjectOptions.xml and take ejb generator options
		 */

		// for test purpose only:
		// GeneratorOptions ejbOptions = new GeneratorOptions("c:/temp", "ejbclass",
		// "templates", "{0}.java", true, "ejb");
		// ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator",
		// ejbOptions);

		// ejbOptions.setTemplateDir(pluginDir + File.separator +
		// ejbOptions.getTemplateDir()); //apsolutna putanja
	}

	public boolean close() {
		return true;
	}

	public boolean isSupported() {
		return true;
	}
}
