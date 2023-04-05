package it.amedea.rest.day.procedures;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.common.procedures.ProcedureAbstract;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.dtos.WebrestDay_InsCodeline;

public class SpInsCodeLine extends ProcedureAbstract {
	private static final Logger logger = LogManager.getLogger(SpInsCodeLine.class);
	public SpInsCodeLine(DataSource datasource, String schema, String procedureName) {
		super(datasource, schema, procedureName);
		declareParameter(new SqlParameter("in_id", Types.NUMERIC));
		declareParameter(new SqlParameter("in_codeline", Types.VARCHAR));
		declareParameter(new SqlOutParameter(OUT_RET_VAL, Types.NUMERIC));
		declareParameter(new SqlOutParameter(OUT_RET_MESSAGE, Types.VARCHAR));
		compile();
	}

	public void executeProcedure(WebrestDay_InsCodeline webrestDay_InsCodeline) throws RestException {
		EsitoSpBean esitoSpBean = new EsitoSpBean();
		logger.debug(webrestDay_InsCodeline.toString());
		Map<String, Object> out = super.executeProcedure(webrestDay_InsCodeline.getIn_id(),
				webrestDay_InsCodeline.getIn_codeline());
		
		esitoSpBean.setEsito( (BigDecimal) out.get(OUT_RET_VAL));
		esitoSpBean.setMessage((String) out.get(OUT_RET_MESSAGE));
		if(esitoSpBean.getEsito().intValue()!=0) {
			RestException restException = new RestException(null, null, false, false);
			restException.setStatusCode(esitoSpBean.getEsito());
			restException.setStatusMessage(esitoSpBean.getMessage());	
			throw  restException;
		}

	}

}
