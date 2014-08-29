package br.uiautomator.test.framework;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;

/***
 * This class was created to access the framework using the UiAutomator framework
 * @author tls
 * @see thiagoolsilva@gmail.com
 * @version 0.00.01
 */
public class FacadeUIAutomator {

	private static FacadeUIAutomator sInstance;

	private Clicker mClicker;
	private SearchUtil mSearchUtil;
	private DeviceUtil mDeviceUtil;
	private Sleeper mSleeper;

	private FacadeUIAutomator(UiDevice dut) {
		if (dut == null) {
			throw new IllegalArgumentException("The DUT most be not null");
		}

		// Instance the objects
		mClicker = new Clicker(dut);
		mSearchUtil = new SearchUtil();
		mDeviceUtil = new DeviceUtil(dut);
		mSleeper = new Sleeper();
	}

	/***
	 * Get a instance of Framework
	 * 
	 * @param dut
	 * @return
	 */
	public static FacadeUIAutomator getInstance(UiDevice dut) {
		if (sInstance == null) {
			sInstance = new FacadeUIAutomator(dut);
		}
		return sInstance;
	}

	/***
	 * Click long on text
	 * 
	 * @param text
	 *            Text
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickLongOntext(String text) throws UiObjectNotFoundException {
		mClicker.clickLongOntext(text);
	}

	/***
	 * Click on component Button with text passed
	 * 
	 * @param text
	 *            text
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickOnButton(String text) throws UiObjectNotFoundException {
		mClicker.clickOnButton(text);
	}

	/***
	 * Click on Component Button and wait to it show a new Window
	 * 
	 * @param text
	 *            text
	 * @param delayToWaitNewWindow
	 *            delay to wait to another window be showed
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickOnButton(String text, int delayToWaitNewWindow)
			throws UiObjectNotFoundException {
		mClicker.clickOnButton(text, delayToWaitNewWindow);
	}

	/***
	 * Click on component Button using the index of Button inserted on Program
	 * 
	 * @param index
	 *            index
	 * @throws UiObjectNotFoundException
	 *             if the index was not found, than a exception will be throw
	 */
	public void clickOnButton(int index) throws UiObjectNotFoundException {
		mClicker.clickOnButton(index);
	}

	/***
	 * CLick on Text
	 * 
	 * @param text
	 *            text
	 * @throws UiObject
	 *             NotFoundException if the text was not found, than a exception
	 *             will be throw
	 */
	public void clickOnText(String text) throws UiObjectNotFoundException {
		mClicker.clickOnText(text);
	}

	public void clickOnText(String text, boolean scroll)
			throws UiObjectNotFoundException {
		mClicker.clickOnText(text, scroll);
	}

	/***
	 * Try to click on text inserted into a list or window
	 * 
	 * @param text
	 *            text
	 * @param scroll
	 *            true if try to find a scroll on window, false try to find the
	 *            text on window
	 * @param maxScrol
	 *            maxScroll to find the text inserted on window
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickOnText(String text, boolean scroll, int maxScrol)
			throws UiObjectNotFoundException {
		mClicker.clickOnText(text, scroll, maxScrol);
	}

	/***
	 * Click on text that contains the string passed on method
	 * 
	 * @param text
	 *            text
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickOnTextContain(String text)
			throws UiObjectNotFoundException {
		mClicker.clickOnTextContain(text);
	}

	/***
	 * Click on text that end with text passed
	 * 
	 * @param text
	 *            contains
	 * @throws UiObjectNotFoundException
	 *             if the text was not found, than a exception will be throw
	 */
	public void clickOnTextEndWith(String text)
			throws UiObjectNotFoundException {
		mClicker.clickOnTextEndWith(text);
	}

	/**
	 * Click on EditText using its index
	 * 
	 * @param index
	 *            index of EditText
	 * @throws UiObjectNotFoundException
	 *             if the EditText was not found, than a exception will be throw
	 */
	public void clickOnEditText(int index) throws UiObjectNotFoundException {
		mClicker.clickOnEditText(index);
	}

	/***
	 * Click on EditText using its text and index
	 * 
	 * @param text
	 *            text to be found
	 * @param index
	 *            index used to find it
	 * @throws UiObjectNotFoundException
	 *             if the EditText was not found, than a exception will be throw
	 */
	public void clickOnEditText(String text, int index)
			throws UiObjectNotFoundException {
		mClicker.clickOnEditText(text, index);
	}

	/***
	 * Click on Screen using the x and Y point
	 * 
	 * @param x
	 *            point
	 * @param y
	 *            point
	 */
	public void clickOnScreen(int x, int y) {
		mClicker.clickOnScreen(x, y);
	}

	/***
	 * Click on Screen using the x and y point
	 * 
	 * @param x
	 *            point
	 * @param y
	 *            point
	 * @param numberOfClicks
	 *            number of click on x/y point
	 */
	public void clickOnScreen(int x, int y, int numberOfClicks) {
		mClicker.clickOnScreen(x, y, numberOfClicks);
	}

	/***
	 * Click on ImageView using its index
	 * 
	 * @param index
	 *            index of ImageView
	 * @throws UiObjectNotFoundException
	 *             if the ImageView was not found, than a exception will be
	 *             throw
	 */
	public void clickOnImage(int index) throws UiObjectNotFoundException {
		mClicker.clickOnImage(index);
	}

	/***
	 * Click on CheckBox using its index
	 * 
	 * @param index
	 *            index
	 * @throws UiObjectNotFoundException
	 *             if the CheckBox was not found, than a exception will be throw
	 */
	public void clickOnCheckBox(int index) throws UiObjectNotFoundException {
		mClicker.clickOnCheckBox(index);
	}

	/***
	 * Click on RadioButton using its index
	 * 
	 * @param index
	 *            index of radioButton
	 * @throws UiObjectNotFoundException
	 *             if the CheckBox was not found, than a exception will be throw
	 */
	public void clickOnRadionButton(int index) throws UiObjectNotFoundException {
		mClicker.clickOnRadionButton(index);
	}

	/***
	 * Search for a textView on Screen. It´s good when you are waiting for a Toast message. The default delay is 2 seconds
	 * @param text text that going to be found
	 * @return true if the text was found 
	 */
	public boolean searchForTextView(String text) {
		return mSearchUtil.searchForTextView(text);
	}

	/***
	 * Search for a Button on Windows
	 * @param text text inserted on button
	 * @return true if the button was founded
	 */
	public boolean searchForButton(String text) {
		return mSearchUtil.searchForButton(text);
	}

	/****
	 * Search for a ToggleButton inserted on Windows
	 * @param text the text inserted on ToggleButton
	 * @return true if the component was founded on window
	 */
	public boolean searchToggleButton(String text) {
		return mSearchUtil.searchToggleButton(text);
	}

	/***
	 * Lock the screen
	 */
	public void lockScreen() {
		mDeviceUtil.lockScreen();
	}

	/****
	 * Unlock the screen
	 */
	public void unLockScreen() {
		mDeviceUtil.unLockScreen();
	}

	/***
	 * Open the notification bar. 
	 */
	public void openNotificationBar() {
		mDeviceUtil.openNotificationBar();
	}

	/***
	 * Press on Menu if there is one 
	 */
	public void pressMenu() {
		mDeviceUtil.pressMenu();
	}

	/***
	 * Stop the test using the time passed on method
	 * @param time the time to sleep the test
	 */
	public void wait(int time) {
		mSleeper.sleep(time);
	}
}
