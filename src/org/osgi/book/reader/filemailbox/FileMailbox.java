package org.osgi.book.reader.filemailbox;

import java.io.File;

import org.osgi.book.reader.api.Mailbox;
import org.osgi.book.reader.api.Message;

public class FileMailbox implements Mailbox {

	private static final long[] EMPTY = new long[0];
	
	public FileMailbox(File file) {}
	
	@Override
	public long[] getAllMessages() { return EMPTY; }

	@Override
	public Message[] getMessages(long[] ids) {
		return new Message[0];
	}
	
	@Override
	public long[] getMessagesSince(long id) {
		return EMPTY;
	}

	@Override
	public void markRead(boolean read, long[] ids) {}
}
