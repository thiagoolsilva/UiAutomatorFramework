package br.uiautomator.test.testcase;

import br.uiautomator.test.framework.FacadeUIAutomator;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestUiFramework extends UiAutomatorTestCase {

	private FacadeUIAutomator mUiAutomator;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mUiAutomator = FacadeUIAutomator.getInstance(getUiDevice());
	}

}
