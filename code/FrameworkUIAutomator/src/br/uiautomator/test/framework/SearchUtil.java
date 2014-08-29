package br.uiautomator.test.framework;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;

/***
 * 
 * @author tls
 * @see thiagoolsilva@gmail.com
 * @version 0.00.01
 */
class SearchUtil {

	private static final int DEFAULT_DELAY = 2000;

	public boolean searchForTextView(String text){
		return searchForComponent(Constants.TEXT_VIEW_CLASS, text, DEFAULT_DELAY);
	}
	
	public boolean searchForButton(String text) {
		return searchForComponent(Constants.BUTTON_CLASS, text, DEFAULT_DELAY);
	}
	
	public boolean searchToggleButton(String text) {
		return searchForComponent(Constants.TOGGLE_BUTTON_CLASS, text, DEFAULT_DELAY);
	}
	
	private boolean searchForComponent(String clasz,String text, int delayToItShow) {
		UiSelector selText = new UiSelector().text(text).className(clasz);

		UiObject objText = new UiObject(selText);
		return objText.waitForExists(delayToItShow);
	}

}
