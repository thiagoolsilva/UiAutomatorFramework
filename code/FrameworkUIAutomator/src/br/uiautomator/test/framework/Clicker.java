package br.uiautomator.test.framework;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

/***
 * 
 * @author tls
 * @see thiagoolsilva@gmail.com
 * @version 0.00.01
 */
class Clicker {

	private UiDevice mDevice;
	private Sleeper mWaiter;

	private static final int DEFAULT_DELAY = 2000;
	private static final int DEFAULT_DELAY_1000 = 1000;

	public Clicker(UiDevice dut) {
		this.mDevice = dut;
		mWaiter = new Sleeper();
	}

	public void clickOnButton(String text) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().text(text).className(
				Constants.BUTTON_CLASS);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException("button with text" + text
					+ "not found");
		}
	}

	public void clickOnButton(String text, int delayToWaitNewWindow)
			throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().text(text).className(
				Constants.BUTTON_CLASS);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.clickAndWaitForNewWindow(delayToWaitNewWindow);
		} else {
			throw new UiObjectNotFoundException("Button with text" + text
					+ "not found on Window");
		}
	}

	public void clickOnButton(int index) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().index(index).className(
				Constants.BUTTON_CLASS);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException("Text not clickOnButton ");
		}
	}

	public void clickOnText(String text) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().text(text);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException(
					"Text not found on method clickOnText");
		}
	}
	
	public void clickOnTextContain(String text) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().textContains(text);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException(
					"Text not found on method clickOnTextContain");
		}
	}
	
	public void clickOnTextEndWith(String text) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().textStartsWith(text);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException(
					"Text not found on method clickOnTextEndWith");
		}
	}
	

	public void clickOnText(String text, boolean scroll)
			throws UiObjectNotFoundException {
		clickOnText(text, scroll, 100);
	}

	public void clickOnText(String text, boolean scroll, int maxScrol)
			throws UiObjectNotFoundException {
		if (!scroll) {
			clickOnText(text);
		} else {
			UiScrollable selScroll = new UiScrollable(new UiSelector());
			
			try {
				selScroll.setMaxSearchSwipes(maxScrol);
			} catch (Exception e) {
				//Do nothing
			}
			
			selScroll.scrollTextIntoView(text);
			selScroll.waitForExists(DEFAULT_DELAY);

			// Create the object
			UiObject objScrollable = selScroll
					.getChildByText(new UiSelector()
							.className(Constants.TEXT_VIEW_CLASS), text);
			if (objScrollable.exists()) {
				// Click on object into the listView
				objScrollable.click();
			} else {
				throw new UiObjectNotFoundException(
						"There is no object on list or the list do not exists on window");
			}
		}
	}

	public void clickOnEditText(int index) throws UiObjectNotFoundException {
		clickOnEditText("", index);
	}

	public void clickOnEditText(String text, int index)
			throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().index(index)
				.className(Constants.EDIT_TEXT_CLASS).text(text);
		UiObject objclickTextButton = new UiObject(selButton);

		if (objclickTextButton.exists()) {
			objclickTextButton.click();
		} else {
			throw new UiObjectNotFoundException("EditText not found on window");
		}
	}

	public void clickOnScreen(int x, int y) {
		mDevice.click(x, y);
	}

	public void clickOnScreen(int x, int y, int numberOfClicks) {
		if (numberOfClicks == 0) {
			clickOnScreen(x, y);
			return;
		}

		// Iterate over the elements
		for (int count = 0; count < numberOfClicks; count++) {
			clickOnScreen(x, y);
			mWaiter.sleep(DEFAULT_DELAY_1000);
		}
	}

	public void clickOnImage(int index) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().index(index).className(Constants.IMAGE_VIEW_CLASS).index(index);
		UiObject objclickTextButton =  new UiObject(selButton);
		
		if(objclickTextButton.exists()){
			objclickTextButton.click();
		}else{
			throw new UiObjectNotFoundException("Image not found on window");
		}
	}
	
	public void clickOnCheckBox(int index) throws UiObjectNotFoundException{
		UiSelector selButton = new UiSelector().className(Constants.CHECKBOX_CLASS).index(index);
		UiObject objclickTextButton =  new UiObject(selButton);
		
		if(objclickTextButton.exists()){
			objclickTextButton.click();
		}else{
			throw new UiObjectNotFoundException("CheckBox not found on window");
		}
	}
	
	public void clickOnRadionButton(int index) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().className(Constants.RADIO_BUTTON_CLASS).index(index);
		UiObject objclickTextButton =  new UiObject(selButton);
		
		if(objclickTextButton.exists()){
			objclickTextButton.click();
		}else{
			throw new UiObjectNotFoundException("RadioButton not found on window");
		}
	}
	
	public void clickLongOntext(String text) throws UiObjectNotFoundException {
		UiSelector selButton = new UiSelector().text(text);
		UiObject objclickTextButton =  new UiObject(selButton);
		
		if(objclickTextButton.exists()){
			objclickTextButton.longClick();
		}else{
			throw new UiObjectNotFoundException("Text not found on window");
		}
	}
	
	
	
	//This code must be used for clean all code up, but the SDK used on test have a limit for use it.
	//	public <T extends View> void clickOn(Class<T> viewClass, int index) throws UiObjectNotFoundException {
	//		UiSelector selButton = new UiSelector().className(CHECKBOX_CLASS).index(index);
	//		UiObject objclickTextButton =  new UiObject(selButton);
	//		
	//		if(objclickTextButton.exists()){
	//			objclickTextButton.click();
	//		}else{
	//			throw new UiObjectNotFoundException("EditText not found on window");
	//		}
	//	}
}
