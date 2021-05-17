package org.mql.store.web.actions;

abstract public class ActionFactory {
	
	abstract public ProductAction getProductAction();
	
	public static ActionFactory getDefaultActionFactory(String source) {
		return new LocalActionFactory(source);
	}
}
