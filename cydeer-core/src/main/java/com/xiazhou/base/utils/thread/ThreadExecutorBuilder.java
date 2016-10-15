package com.xiazhou.base.utils.thread;

import com.xiazhou.base.utils.IUtilsBuilder;

import java.util.concurrent.Executors;

/**
 * Created by zhangsong on 15/11/13.
 */
public class ThreadExecutorBuilder implements IUtilsBuilder<ThreadExecutor> {
	private static final String TYPE_FIXED = "fixed";
	// 线程池生成类型，默认生成固定大小【fixed】的线程池
	private String type = "fixed";
	// 固定线程池的池大小，默认值 20
	private int fixedSize = 20;

	@Override
	public String getConfName() {
		return "utils";
	}

	@Override
	public ThreadExecutor build() {
		if(TYPE_FIXED.equalsIgnoreCase(type)){
			if(fixedSize <= 0)
				throw new IllegalArgumentException("配置项：utils.ThreadExecutor.fixedSize 的值不能小于或等于 0");
			ThreadExecutorImpl executor = new ThreadExecutorImpl(Executors.newFixedThreadPool(fixedSize));
			executor.start();
			return executor;
		}else{
			throw new IllegalArgumentException("目前只支持创建固定大小【fixed】类型的线程池");
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFixedSize(int fixedSize) {
		this.fixedSize = fixedSize;
	}
}
