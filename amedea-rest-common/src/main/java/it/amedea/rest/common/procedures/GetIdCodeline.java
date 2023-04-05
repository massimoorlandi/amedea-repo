package it.amedea.rest.common.procedures;
import java.math.BigDecimal;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

public class GetIdCodeline {
	private static final Logger logger = LogManager.getLogger(GetIdCodeline.class);
	private static String SELECT = "SELECT ";
	private static String DUAL = " FROM DUAL";
	private StringBuilder builder;
    private DataSource dataSource;
    
    public GetIdCodeline(DataSource dataSource, String schema, String functionName) {
    	this.dataSource = dataSource;
    	builder = new StringBuilder();
    	builder.append(SELECT);
    	builder.append(schema + ".");
    	builder.append(functionName );
    	builder.append(DUAL);
    }

    public BigDecimal run() {
    	SqlFunction<BigDecimal> sqlFunction = new SqlFunction<BigDecimal>(dataSource, builder.toString());
        BigDecimal result = (BigDecimal) sqlFunction.runGeneric();
        return result;
    }
}