package org.osgi.tutorial;

import org.osgi.book.reader.api.Mailbox;
import org.osgi.book.reader.api.MailboxException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class MessageCountActivator implements BundleActivator {

	private BundleContext context;
	
	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		printMessageCount();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

	private void printMessageCount() throws MailboxException {
		ServiceReference ref = context.getServiceReference(Mailbox.class.getName());
		if (ref != null) {
			Mailbox mbox = (Mailbox) context.getService(ref);
			if (mbox != null) {
				try {
					int count = mbox.getAllMessages().length;
					System.out.println("There are " + count + " messages");
				} finally {
					context.ungetService(ref);
				}
			}
		}
	}
}
