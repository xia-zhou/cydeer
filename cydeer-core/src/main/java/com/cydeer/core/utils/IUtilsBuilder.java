package com.cydeer.core.utils;

/**
 * @author Cydeer on 15/9/9.
 */
public interface IUtilsBuilder<T> {
    String getConfName();

    T build();
}
