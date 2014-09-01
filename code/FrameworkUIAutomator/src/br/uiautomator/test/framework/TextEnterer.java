package br.uiautomator.test.framework;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class TextEnterer {

	public void setEditText(String textToBeFound, String text) throws UiObjectNotFoundException{
		UiSelector selText = new UiSelector().className(Constants.TEXT_VIEW_CLASS).text(textToBeFound);
		UiObject objText = new UiObject(selText);
		if(objText.exists()) {
			objText.setText(text);
		}else {
			throw new UiObjectNotFoundException("");
		}
	}
}
