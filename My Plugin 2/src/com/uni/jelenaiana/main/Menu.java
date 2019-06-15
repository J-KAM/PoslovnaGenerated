package com.uni.jelenaiana.main;

import java.awt.event.ActionEvent;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.ui.ScalableImageIcon;

public class Menu {

	public void register() {
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
        manager.addMainMenuConfigurator(createMain());
	}

	private AMConfigurator createMain() {
		return new AMConfigurator() {
			public void configure(ActionsManager mngr) {
				ActionsCategory category = (ActionsCategory) mngr.getActionFor("Code Generation");
				if (category == null) {
					category = new MDActionsCategory("Code Generation", "Code Generation");
					category.setNested(true);
					mngr.addCategory(category);
				}
				category.addAction(new Entry());
			}
		};
	}

	private class Entry extends MDAction {
		private static final long serialVersionUID = 12435234234324L;
		ActionEventHandler handler = new ActionEventHandler();
		
		public Entry(String arg0, String arg1, int arg2, String arg3) {
			super(arg0, arg1, arg2, arg3);
		}

		public Entry() {
			super("Generate", "Generate", 0, null);
			setLargeIcon(new ScalableImageIcon(getClass(), "main_toolbar_icon.gif"));
		}

		public void actionPerformed(ActionEvent e) {
			handler.handle(e);
		}
	}
}
