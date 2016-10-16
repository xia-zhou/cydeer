package com.cydeer.core.dao.impl;

import com.cydeer.core.dao.api.CommonDao;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author Cydeer on 15/11/12.
 */
public class SimpleSqlSessionImpl implements CommonDao.SimpleSqlSession {
	private SqlSession sqlSession;
	private String statement;

	public SimpleSqlSessionImpl(SqlSession sqlSession, String statement) {
		this.sqlSession = sqlSession;
		this.statement = statement;
	}
	public <T> T selectOne() {
		return this.sqlSession.selectOne(this.statement);
	}

	public <T> T selectOne(Object parameter) {
		return this.sqlSession.selectOne(this.statement, parameter);
	}

	public <E> List<E> selectList() {
		return this.sqlSession.selectList(this.statement);
	}

	public <E> List<E> selectList(Object parameter) {
		return this.sqlSession.selectList(this.statement, parameter);
	}

	public <E> List<E> selectList(Object parameter, RowBounds rowBounds) {
		return this.sqlSession.selectList(this.statement, parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String mapKey) {
		return this.sqlSession.selectMap(this.statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(Object parameter, String mapKey) {
		return this.sqlSession.selectMap(this.statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(Object parameter, String mapKey, RowBounds rowBounds) {
		return this.sqlSession.selectMap(this.statement, parameter, mapKey, rowBounds);
	}

	public void select(Object parameter, ResultHandler handler) {
		this.sqlSession.select(this.statement, parameter, handler);
	}

	public void select(ResultHandler handler) {
		this.sqlSession.select(this.statement, handler);
	}

	public void select(Object parameter, RowBounds rowBounds, ResultHandler handler) {
		this.sqlSession.select(this.statement, parameter, rowBounds, handler);
	}

	public int insert() {
		return this.sqlSession.insert(this.statement);
	}

	public int insert(Object parameter) {
		return this.sqlSession.insert(this.statement, parameter);
	}

	public int update() {
		return this.sqlSession.update(this.statement);
	}

	public int update(Object parameter) {
		return this.sqlSession.update(this.statement, parameter);
	}

	public int delete() {
		return this.sqlSession.delete(this.statement);
	}

	public int delete(Object parameter) {
		return this.sqlSession.delete(this.statement, parameter);
	}
}
