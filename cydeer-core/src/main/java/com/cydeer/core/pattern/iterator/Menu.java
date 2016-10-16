package com.cydeer.core.pattern.iterator;

import java.util.Iterator;

/**
 * @author Cydeer on 16/6/8.
 */
public interface Menu {
	Iterator<MenuItem> createIterator();
}
