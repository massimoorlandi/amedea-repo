package it.amedea.rest.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.amedea.rest.common.procedures.GetIdCodeline;


@SpringBootApplication(scanBasePackages = "it.amedea.rest")
public class AmedeaRestCommonApplication {
	private static final Logger logger = LogManager.getLogger(AmedeaRestCommonApplication.class);
	
//	@Autowired
//	SqlFunctionExample sqlFunctionExample;
	
	public static void main(String[] args) {
		SpringApplication.run(AmedeaRestCommonApplication.class, args);
		logger.info("Main Application started");
//		context.getBean(SqlFunctionExample.class).runExample();
//		AmedeaRestCommonApplication amedeaRestCommonApplication = new AmedeaRestCommonApplication();
//		amedeaRestCommonApplication.sqlFunctionExample.runExample();
	}

}
