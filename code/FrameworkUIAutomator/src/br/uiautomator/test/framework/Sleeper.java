package br.uiautomator.test.framework;

/***
 * 
 * @author tls
 * @see thiagoolsilva@gmail.com
 * @version 0.00.01
 */
class Sleeper {

	public void sleep(long timeToSleep) {
		long start = System.currentTimeMillis();
		long duration = timeToSleep;
		boolean interrupted = false;
		do {
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				interrupted = true;
			}
			duration = start + timeToSleep - System.currentTimeMillis();
		} while (duration > 0);

		if (interrupted) {
			// Important: we don't want to quietly eat an interrupt() event,
			// so we make sure to re-interrupt the thread so that the next
			// call to Thread.sleep() or Object.wait() will be interrupted.
			Thread.currentThread().interrupt();
		}
	}
}
