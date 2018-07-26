package com.cw.common.daemon;

import org.apache.commons.daemon.Daemon;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 抽象进程类
 * @author yuanguangjie
 *
 */
public abstract class AbstractDaemon implements Daemon {
	protected AnnotationConfigApplicationContext context;
	private boolean shutdownRequested = false;
	protected Thread workThread; //线程

	protected abstract void run();

	protected Thread getWorkThread() {
		return workThread;
	}

	protected void createWorkThread() {
		final AbstractDaemon instance = this;
		workThread = new Thread() {
			@Override
			public synchronized void start() {
				super.start();
			}

			@Override
			public void run() {
				instance.run();
			}
		};
	}

	protected boolean isShutdownRequested() {
		return shutdownRequested;
	}

	/**
	 * @param shutdown
	 *            flag to set
	 */
	protected void setShutdownRequested(boolean shutdownRequested) {
		this.shutdownRequested = shutdownRequested;
	}

	@Override
	public void destroy() {
		if (context != null) {
			context.close();
		}
		workThread = null;
	}

}
