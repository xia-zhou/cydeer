/*
 * Copyright (C), 2014-2015, 
 * FileName: JacksonB.java
 * Author:   xia zhou
 * Date:     2015年6月11日 下午9:42:06
 * Description: 
 */
package com.xiazhou.base.utils.jackson;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 〈一句话是什么〉
 * 〈详细描述做什么〉
 *
 * @author xia zhou
 */
public class JacksonB {
	public static Type SIMPLE = Type.SIMPLE;

	private static Map<Type, JacksonB> instanceMap = new HashMap<Type, JacksonB>();


	// 获取默认实例
	public static JacksonB base() {
		return JacksonB.simple(Type.DEFAULT);
	}

	// 获取指定实例
	public static JacksonB simple(Type type) {
		JacksonB inst = instanceMap.get(type);
		if (inst == null) {
			synchronized (JacksonB.class) {
				inst = instanceMap.get(type);
				if (inst == null) {
					inst = new JacksonB(type);
					instanceMap.put(type, inst);
				}
			}
		}
		return inst;
	}

	private static enum Type {
		DEFAULT, // 标准版本
		SIMPLE, // 精简版，主要用于缓存Key的值生成
	}

	private ObjectMapper objectMapper;

	private JacksonB(Type type) {
		this.objectMapper = new ObjectMapper();
		switch (type) {
		case DEFAULT:
			break;
		case SIMPLE:
			// 属性排序，保证顺序生成JSON
			objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			// 对于值为空的属性不生成
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			// 去除属性名称的双引号
			objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
			objectMapper.addMixInAnnotations(Object.class, DynamicFieldFilterProvider.class);
			objectMapper.setFilters(new DynamicFieldFilterProvider(null, null));
			break;
		}
	}

	public TypeFactory getTypeFactory() {
		return this.objectMapper.getTypeFactory();
	}

	/**
	 * 设计日期格式的序列化格式
	 * 
	 * @param format
	 */
	public void setSimpleDateFormat(String format) {
		this.objectMapper.setDateFormat(new SimpleDateFormat(format));
	}

	public ObjectMapper getObjectMapper() {
		return this.objectMapper;
	}

	public <T> T readValue(String content, Class<T> valueType) {
		try {
			return this.objectMapper.readValue(content, valueType);
		} catch (JsonParseException e) {
			throw new RuntimeException("JsonParseException throwed, please check!", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException throwed, please check!", e);
		} catch (IOException e) {
			throw new RuntimeException("IOException throwed, please check!", e);
		}
	}

	public <T> T readValue(String content, TypeReference<?> valueTypeRef) {
		try {
			return this.objectMapper.readValue(content, valueTypeRef);
		} catch (JsonParseException e) {
			throw new RuntimeException("JsonParseException throwed, please check!", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException throwed, please check!", e);
		} catch (IOException e) {
			throw new RuntimeException("IOException throwed, please check!", e);
		}
	}

	public <T> T readValue(String content, JavaType valueType) {
		try {
			return this.objectMapper.readValue(content, valueType);
		} catch (JsonParseException e) {
			throw new RuntimeException("JsonParseException throwed, please check!", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException throwed, please check!", e);
		} catch (IOException e) {
			throw new RuntimeException("IOException throwed, please check!", e);
		}
	}

	public void writeValue(Writer w, Object value) {
		try {
			this.objectMapper.writeValue(w, value);
		} catch (JsonGenerationException e) {
			throw new RuntimeException("JsonGenerationException throwed, please check!", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException throwed, please check!", e);
		} catch (IOException e) {
			throw new RuntimeException("IOException throwed, please check!", e);
		}
	}

	public String writeValueAsString(Object value) {
		return this.writeValueAsString(value, null);
	}

	public String writeValueAsString(Object value, String[] includeFields) {
		try {
			if (includeFields != null && includeFields.length > 0) {
				FilterProvider filters = new DynamicFieldFilterProvider(this.objectMapper.getSerializationConfig()
						.getFilterProvider(), SimpleBeanPropertyFilter.filterOutAllExcept(includeFields));
				return this.objectMapper.writer(filters).writeValueAsString(value);
			} else {
				return this.objectMapper.writeValueAsString(value);
			}
		} catch (JsonGenerationException e) {
			throw new RuntimeException("JsonGenerationException throwed, please check!", e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException throwed, please check!", e);
		} catch (IOException e) {
			throw new RuntimeException("IOException throwed, please check!", e);
		}
	}
}
