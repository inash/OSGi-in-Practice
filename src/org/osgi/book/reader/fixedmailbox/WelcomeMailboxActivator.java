package org.osgi.book.reader.fixedmailbox;

import java.util.Properties;

import org.osgi.book.reader.api.Mailbox;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class WelcomeMailboxActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		Mailbox mbox = new FixedMailbox();
		
		Properties props = new Properties();
		props.put(Mailbox.NAME_PROPERTY, "welcome");
		context.registerService(Mailbox.class.getName(), mbox, props);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}
}
