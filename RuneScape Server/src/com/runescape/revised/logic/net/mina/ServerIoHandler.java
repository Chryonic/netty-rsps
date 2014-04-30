package com.runescape.revised.logic.net.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerIoHandler extends IoHandlerAdapter {

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#exceptionCaught(org.apache.mina.core.session.IoSession, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(final IoSession session, final Throwable throwable) throws Exception {
		session.close(false);
	}

	@Override
	public void messageReceived(final IoSession session, final Object message) throws Exception {
		// engine.pushTask(new SessionMessageTask(session, (Packet) message));
	}

	@Override
	public void sessionClosed(final IoSession session) throws Exception {}

	@Override
	public void sessionIdle(final IoSession session, final IdleStatus status) throws Exception {
		session.close(false);
	}

	@Override
	public void sessionOpened(final IoSession session) throws Exception {}
}