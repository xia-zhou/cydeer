package com.xiazhou.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by zhangsong on 15/9/9.
*/

public class Utils {
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	private static final String BUILDER = "Builder";
	private static Map<String, IUtils> utilsMap = new HashMap<String, IUtils>();

	/**
	 * 创建默认实例<BR>
	 * 实例的创建是单例模式，请保持组件的线程安全
	 *
	 * @param utilClz
	 * @return
	 */
	public static <T extends IUtils> T get(Class<T> utilClz) {
		return Utils.get(utilClz, null);
	}

	/**
	 * 以 instance 名称为标识，创建Utils容器中的多个实例<BR>
	 * 实例的创建是单例模式，请保持组件的线程安全
	 *
	 * @param utilClz
	 * @param instance
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IUtils> T get(Class<T> utilClz, String instance) {
		String key = StringUtils.isBlank(instance) ? utilClz.getName() : StringUtils.join(utilClz.getName(), ".",
				instance);
		IUtils util = utilsMap.get(key);
		if (util == null) {
			synchronized (IUtils.class) {
				if (util == null) {
					util = Utils.build(utilClz, instance);
					utilsMap.put(key, util);
				}
			}
		}
		return (T) util;
	}

	@SuppressWarnings("unchecked")
	private static <T extends IUtils> T build(Class<T> utilClz, String instance) {
		String builderName = utilClz.getName() + BUILDER;
		IUtilsBuilder<T> builder = null;
		try {
			Class<?> builderClass = Class.forName(builderName);
			if (!IUtilsBuilder.class.isAssignableFrom(builderClass))
				throw new IllegalArgumentException("工厂类 " + builderName + " 必须实现 IUtilsBuilder 接口");
			builder = (IUtilsBuilder<T>) builderClass.newInstance();
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("找不到 " + utilClz.getName() + " 工厂类 " + builderName, e);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalStateException("创建 " + builderName + " 实例失败", e);
		}
		/*// 如果没有指定配置文件，则不进行Builder属性的设置
		if (StringUtils.isBlank(builder.getConfName()))
			return builder.build();
		// 根据 Builder 中的 set 属性，读取相应 conf 配置文件的值进行注入
		String propertiesKey = StringUtils.join(builder.getConfName(), ".",
				StringUtils.substringAfterLast(utilClz.getName(), "."), ".");
		if (StringUtils.isNotBlank(instance))
			propertiesKey = StringUtils.join(propertiesKey, instance, ".");

		for (Method method : builder.getClass().getDeclaredMethods()) {
			if (method.getName().startsWith("set") && method.getParameterTypes().length == 1
					&& Modifier.isPublic(method.getModifiers())) {
				String property = method.getName().length() > 3 ? method.getName().substring(3, 4).toLowerCase()
						+ method.getName().substring(4) : "";
				*//*Object object = confProperties.get(propertiesKey + property);
				try {
					if (object != null) {
						BeanUtils.setProperty(builder, property, object);
					}
				} catch (IllegalAccessException | InvocationTargetException e) {
					logger.error("通过方法 " + method.getName() + " 属性注入失败： " + e.getMessage(), e);
				}*//*
			}
		}*/

		return builder.build();
	}
}
