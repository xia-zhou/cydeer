package com.xiazhou.base.dao.factory;

import com.xiazhou.base.dao.api.CommonDao;
import com.xiazhou.base.dao.impl.CommonDaoImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zhangsong on 15/11/12.
 */
public class CommonDaoFactoryBean implements FactoryBean<CommonDao>, InitializingBean {

	private SqlSessionFactory sqlSessionFactory;
	private CommonDao commonDao;

	public CommonDaoFactoryBean() {
	}

	@Override public void afterPropertiesSet() throws Exception {
		if (this.sqlSessionFactory == null) {
			throw new IllegalArgumentException("必须设置 sqlSessionFactory 属性");
		} else {
			this.commonDao = new CommonDaoImpl(this.sqlSessionFactory);
		}
	}

	@Override public CommonDao getObject() throws Exception {
		return this.commonDao;
	}

	@Override public Class<?> getObjectType() {
		return CommonDao.class;
	}

	@Override public boolean isSingleton() {
		return true;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

}
