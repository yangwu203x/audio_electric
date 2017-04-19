package com.xxx.demo.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Integer selectCount(){
	
		return sessionTemplate.selectOne("user.selectCount");
	}
}
