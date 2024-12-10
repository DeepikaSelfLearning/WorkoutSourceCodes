/*
 * 4. Bill Pugh Singleton Design (Initialization-on-demand holder idiom):
		This is the most efficient and thread-safe approach using the inner static class. The instance is created only when the 
		SingletonHelper class is loaded.
 * 
 * 		i)   The SingletonHelper class is loaded only when the getInstance() method is called, triggering the creation of the 
 * 		     singleton instance.
		ii)  This approach is thread-safe, and the class loading mechanism ensures lazy initialization.
		iii) It avoids synchronization overhead and is efficient in both single-threaded and multi-threaded environments.
 */

package com.deepu.singletondesingpattern;

public class Singleton {
	
	private Singleton() {}
	
	private static class SingletonHelper {
		
		private static final Singleton instance = new Singleton();
		
	}

	public static Singleton getInstance() {
		return SingletonHelper.instance;
	}
}
