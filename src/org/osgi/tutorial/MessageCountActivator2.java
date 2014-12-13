package org.osgi.tutorial;

import org.osgi.book.reader.api.Mailbox;
import org.osgi.book.reader.api.MailboxException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class MessageCountActivator2 implements BundleActivator {

	private ServiceTracker mboxTracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		mboxTracker = new ServiceTracker(context, Mailbox.class.getName(), null);
		mboxTracker.open();
		printMessageCount();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		mboxTracker.close();
	}

	private void printMessageCount() throws MailboxException {
		Mailbox mbox = (Mailbox) mboxTracker.getService();
		if (mbox != null) {
			int count = mbox.getAllMessages().length;
			System.out.println("There are " + count + " messages");
		}
	}
}
