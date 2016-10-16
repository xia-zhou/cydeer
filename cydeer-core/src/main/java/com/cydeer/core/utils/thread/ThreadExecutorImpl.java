package com.cydeer.core.utils.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 异步线程处理器<br/>
 * 线程池通过 {@link java.util.concurrent.Executors}来创建，线程池主要有以下模式：<br/>
 * 1. 固定大小的线程池，newFixedThreadPool<br/>
 * 创建固定大小的线程池运行任务，执行的顺序不确定。 <br/>
 * 2. 单任务线程池，newSingleThreadExecutor<br/>
 * 创建单一执行器来执行任务队列，并保证任务的执行，即使因某些原因部分任务执行失败导致线程关闭，<br/>
 * 也会再产生一个工作线程来执行接下来的任务。执行的顺序确定。<br/>
 * 3. 可变尺寸的线程池，newCachedThreadPool<br/>
 * 可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。 <br/>
 * 4. 延迟连接池（计划线程池），newScheduledThreadPool<br/>
 * 可以设定线程延迟指定时间运行，并用固定大小的纯种池来运行。 <br/>
 * 5. 单任务延迟连接池，newSingleThreadScheduledExecutor<br/>
 * 可以设定线程延迟指定时间运行，并用单一线程来运行。
 *
 * @author Cydeer on 15/11/13.
 */
public class ThreadExecutorImpl implements ThreadExecutor {
	private static final Logger log = LoggerFactory.getLogger(ThreadExecutorImpl.class);
	// private LinkedBlockingQueue<Executor> executors;
	// private ExecutorService executorService;
	// private boolean isRunning = true;
	private LinkedBlockingThread linkedThread;//立即执行线程
	private DelayedThread delayedThread;//延迟执行线程

	/**
	 * 包内可调用
	 *
	 * @param executorService
	 */
	ThreadExecutorImpl(ExecutorService executorService) {
		// this.executorService = executorService;
		this.linkedThread = new LinkedBlockingThread(executorService);
		this.delayedThread = new DelayedThread(executorService);
	}

	/**
	 * 添加异步执行的任务
	 *
	 */
	public void execute(Executor executor) {
		if (executor == null)
			return;
		if (executor instanceof DelayedExecutor) {
			this.delayedThread.executors.add((DelayedExecutor) executor);
		} else {
			this.linkedThread.executors.add(executor);
		}
	}

	void start() {
		this.linkedThread.setDaemon(true);
		this.linkedThread.start();
		this.delayedThread.setDaemon(true);
		this.delayedThread.start();
	}

	private static abstract class AbstractBlockingThread<T extends Executor> extends Thread {
		protected ExecutorService executorService;
		protected BlockingQueue<T> executors;

		@Override
		public void run() {
			// 实时运行
			while (true) {
				try {
					Executor executor = executors.take();
					if (executor != null && executorService != null)
						executorService.execute(new TaskJob(executor));
				} catch (InterruptedException e) {
					log.error("", e);
				}
			}
		}
	}

	private static class LinkedBlockingThread extends AbstractBlockingThread<Executor> {

		private LinkedBlockingThread(ExecutorService executorService) {
			this.executorService = executorService;
			this.executors = new LinkedBlockingQueue<Executor>();
		}
	}

	private static class DelayedThread extends AbstractBlockingThread<DelayedExecutor> {

		private DelayedThread(ExecutorService executorService) {
			this.executorService = executorService;
			this.executors = new DelayQueue<DelayedExecutor>();
		}
	}

	// 任务线程
	private static class TaskJob implements java.lang.Runnable {
		private Executor executor;

		public TaskJob(Executor executor) {
			this.executor = executor;
		}

		public void run() {
			if (executor != null) {
				executor.execute();
			}
		}
	}
}