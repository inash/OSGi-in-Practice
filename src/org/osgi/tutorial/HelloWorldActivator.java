package org.osgi.tutorial;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorldActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello, World!");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye, World!");
	}
}
