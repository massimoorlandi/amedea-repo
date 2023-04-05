package it.amedea.rest.day;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "it.amedea.rest")
public class AmedeaRestDayApplication {
	private static final Logger logger = LogManager.getLogger(AmedeaRestDayApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AmedeaRestDayApplication.class, args);
		logger.debug("DEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUGDEBUG");
		logger.info("infoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfoinfo");
	}

}


