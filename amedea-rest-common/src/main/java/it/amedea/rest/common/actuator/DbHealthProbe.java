package it.amedea.rest.common.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import it.amedea.rest.common.services.SystemServiceImpl;

@Component("db-probe")
public class DbHealthProbe implements HealthIndicator {

	@Autowired
	SystemServiceImpl systemService;

    
    @Override
    public Health health() {
        int errorCode = systemService.checkDbSatus(); // perform some specific health check
        if (errorCode != 1) {
            return Health.down().withDetail("Error Code", 500).build();
        }   
    	
    	 Health.Builder status = Health.up();
    	 return status
    		      .withDetail("database", systemService.databaseProbe())
    		      .build();    	
    }

}