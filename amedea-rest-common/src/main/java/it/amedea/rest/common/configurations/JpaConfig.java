package it.amedea.rest.common.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class JpaConfig {
	
	@Primary
	@Bean(name = "BIRD DataSource")
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public DataSource  datasource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "BIRD JdbcTemplate")
	public JdbcTemplate createJdbcTemplate(@Autowired @Qualifier("BIRD DataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
