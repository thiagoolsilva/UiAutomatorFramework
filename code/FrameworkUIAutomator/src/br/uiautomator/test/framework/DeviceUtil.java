package br.uiautomator.test.framework;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;

/***
 * 
 * @author tls
 * @see thiagoolsilva@gmail.com
 * @version 0.00.01
 */
class DeviceUtil {

	private UiDevice mDevice;

	public DeviceUtil(UiDevice dut) {
		this.mDevice = dut;
	}

	public void lockScreen() {
		try {
			this.mDevice.sleep();
		} catch (RemoteException e) {
			// Do Nothing
		}
	}

	public void unLockScreen() {
		try {
			this.mDevice.wakeUp();
		} catch (RemoteException e) {
			// Do Nothing
		}
	}
	
	public void pressMenu() {
		this.mDevice.pressMenu();
	}
	
	public void openNotificationBar() {
		this.mDevice.swipe(36, 39, 0, 900, 1);
	}
}
