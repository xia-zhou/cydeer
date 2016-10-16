package com.cydeer.core.dao.impl;

import com.cydeer.core.dao.api.CommonDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Cydeer on 15/11/12.
 */
public class SimpleMapperImpl implements CommonDao.SimpleMapper {
	private Class<?> mapperClass;
	private String sql;
	private CommonDaoImpl commonDaoImpl;
	private String expansion = ".";
	SimpleMapperImpl(CommonDaoImpl commonDaoImpl) {
		this.commonDaoImpl = commonDaoImpl;
	}

	CommonDao.SimpleMapper setMapperClass(Class<?> mapperClass, String expansion) {
		this.mapperClass = mapperClass;
		if(StringUtils.isNotBlank(expansion)) {
			this.expansion = expansion;
		}

		return this;
	}
	@Override public CommonDao.SimpleMapper sql(String sql) {
		this.sql = sql;
		return this;
	}

	@Override public CommonDao.SimpleSqlSession session() {
		this.argumentCheck();
		return new SimpleSqlSessionImpl(this.wrapperSqlSession(), this.buildStatement());
	}

	@Override public <T> T sqlSession(CommonDao.Invoker invoker) {
		this.argumentCheck();
		return invoker.invoke(this.wrapperSqlSession(), this.buildStatement());
	}

	private void argumentCheck() {
		if(this.mapperClass == null) {
			throw new IllegalArgumentException("请设置Mapper名称空间对应的实体");
		} else if(StringUtils.isBlank(this.sql)) {
			throw new IllegalArgumentException("请设置要执行的SQL语句");
		}
	}

	private String buildStatement() {
		return StringUtils.join(new String[]{this.mapperClass.getName(), this.expansion, this.sql});
	}

	private SqlSession wrapperSqlSession() {
		Object sqlSession = this.commonDaoImpl.getSqlSessionProxy();
		return (SqlSession)sqlSession;
	}
}
