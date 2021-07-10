package com.narpavi.finance.karma.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.narpavi.finance.karma.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {
	
	private SqlSession sqlSession;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
