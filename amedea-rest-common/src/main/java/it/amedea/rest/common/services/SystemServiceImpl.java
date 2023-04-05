package it.amedea.rest.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Service;

import it.amedea.rest.common.daos.impl.SystemDaoImpl;

@Service
public class SystemServiceImpl {
	  @Autowired
	  JdbcTemplate template;

	@Autowired
	SystemDaoImpl systemDao;
	
	public String getSystemDate() {
		return systemDao.getSystemDate();
	}

    public int checkDbSatus(){
        List<Object> results = template.query("select 1 from dual",
                new SingleColumnRowMapper<>());
        return results.size();
    }

    public String databaseProbe(){
        String result = template.queryForObject("select instance_name " +
        		"from v$instance ",String.class);
        return result;
    }

    
}
