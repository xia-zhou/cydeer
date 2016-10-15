package com.xiazhou.base.dao.impl;

import com.xiazhou.base.dao.api.CommonDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by zhangsong on 15/11/12.
 */
public class CommonDaoImpl implements CommonDao {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSessionProxy;

	public CommonDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		this.sqlSessionProxy = new SqlSessionTemplate(sqlSessionFactory);
	}

	public SimpleMapper mapper(Class<?> mapperClass) {
		return (new SimpleMapperImpl(this)).setMapperClass(mapperClass, ".");
	}

	SqlSessionFactory getSqlSessionFactory() {
		return this.sqlSessionFactory;
	}

	SqlSession getSqlSessionProxy() {
		return this.sqlSessionProxy;
	}
}
