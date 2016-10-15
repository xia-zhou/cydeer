package com.xiazhou.base.dao.api;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangsong on 15/11/12.
 */
public interface CommonDao {

	CommonDao.SimpleMapper mapper(Class<?> var1);

	public interface SimpleSqlSession {
		<T> T selectOne();

		<T> T selectOne(Object var1);

		<E> List<E> selectList();

		<E> List<E> selectList(Object var1);

		<E> List<E> selectList(Object var1, RowBounds var2);

		<K, V> Map<K, V> selectMap(String var1);

		<K, V> Map<K, V> selectMap(Object var1, String var2);

		<K, V> Map<K, V> selectMap(Object var1, String var2, RowBounds var3);

		void select(Object var1, ResultHandler var2);

		void select(ResultHandler var1);

		void select(Object var1, RowBounds var2, ResultHandler var3);

		int insert();

		int insert(Object var1);

		int update();

		int update(Object var1);

		int delete();

		int delete(Object var1);
	}

	public interface Invoker {
		<T> T invoke(SqlSession var1, String var2);
	}

	public interface SimpleMapper {
		CommonDao.SimpleMapper sql(String var1);

		CommonDao.SimpleSqlSession session();

		<T> T sqlSession(CommonDao.Invoker var1);
	}
}
