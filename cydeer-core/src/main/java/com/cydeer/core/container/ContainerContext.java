package com.cydeer.core.container;

import org.springframework.context.ApplicationContext;

/**
 * @author Cydeer on 15/12/15.
 */
public class ContainerContext {

	private static ContainerContext instance;

	private ContainerContext() {
	}

	public static ContainerContext get() {
		if (instance == null) {
			synchronized (ContainerContext.class) {
				if (instance == null) {
					instance = new ContainerContext();
				}
			}
		}
		return instance;
	}

	private ApplicationContext context;

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	/**
	 * <pre>
	 *
	 * @return 返回Spring容器的 ApplicationContext对象
	 */
	public ApplicationContext getContext() {
		if(this.context == null){
			throw new IllegalStateException("容器为启动，请再启动之后调用");
		}
		return this.context;
	}
}
