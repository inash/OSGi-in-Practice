package org.osgi.book.reader.dbmailbox;

import javax.sql.DataSource;

import org.osgi.book.reader.api.Mailbox;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DbMailboxActivator implements BundleActivator {

	private BundleContext context;
	private ServiceTracker tracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		tracker = new ServiceTracker(context, DataSource.class.getName(), new DSCustomizer());
		tracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		tracker.close();
	}

	private class DSCustomizer implements ServiceTrackerCustomizer {
		
		@Override
		public Object addingService(ServiceReference reference) {
			DataSource ds = (DataSource) context.getService(reference);
			DbMailbox mbox = new DbMailbox(ds);
			ServiceRegistration registration = context.registerService(
					Mailbox.class.getName(), mbox, null);
			return registration;
		}

		@Override
		public void modifiedService(ServiceReference reference, Object service) {}

		@Override
		public void removedService(ServiceReference reference, Object service) {
			ServiceRegistration registration = (ServiceRegistration) service;
			registration.unregister();
			context.ungetService(reference);
		}
	}
}
