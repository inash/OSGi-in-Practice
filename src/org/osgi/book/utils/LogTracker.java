package org.osgi.book.utils;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class LogTracker extends ServiceTracker implements LogService {

	public LogTracker(BundleContext context) {
		super(context, LogService.class.getName(), null);
	}

	public void log(int level, String message) {
		log(null, level, message, null);
	}
}
