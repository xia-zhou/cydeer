package com.cydeer.core.utils.thread;

import com.cydeer.core.utils.IUtils;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Cydeer on 15/11/13.
 */
public interface ThreadExecutor extends IUtils {
	/**
	 * 异步任务执行入口
	 *
	 * @param executor
	 */
	void execute(Executor executor);

	/**
	 * 任务执行器
	 *
	 * @author zhangsong
	 */
	public static interface Executor {
		/**
		 * 任务执行接口
		 *
		 */
		void execute();
	}

	/**
	 * 任务延迟执行器
	 * @author zhsngsong
	 *
	 */
	public static abstract class DelayedExecutor implements Executor, Delayed {
		private long execTime;

		/**
		 * 延迟执行构造器
		 *
		 * @param delayTime
		 *            需要延迟执行的时间，单位毫秒
		 */
		public DelayedExecutor(long delayTime) {
			execTime = delayTime + System.currentTimeMillis();
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(this.execTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed other) {
			if (other == this) // compare zero ONLY if same object
				return 0;
			long d = (getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS));
			return (d > 0) ? 1 : ((d < 0) ? -1 : 0);
		}
	}
}
