package com.xiazhou.base.utils;

/**
 * Created by zhangsong on 15/9/9.
 */
public interface IUtilsBuilder<T> {
    String getConfName();

    T build();
}
