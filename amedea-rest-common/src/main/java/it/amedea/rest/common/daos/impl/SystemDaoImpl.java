package it.amedea.rest.common.daos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SystemDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getSystemDate() {
		return jdbcTemplate.queryForObject("SELECT SYSDATE FROM DUAL", String.class); 
	}
	
}
