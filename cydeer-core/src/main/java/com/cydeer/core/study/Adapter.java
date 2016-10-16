package com.cydeer.core.study;

import java.util.Map;

/**
 * @author Cydeer on 16/6/18.
 */
public interface Adapter {
	Message build(Integer messageId, Map<String, Object> param);
}
