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
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;

public class SpAnnullaSerieBuoni extends ProcedureAbstract {
	private static final Logger logger = LogManager.getLogger(SpAnnullaSerieBuoni.class);
	public SpAnnullaSerieBuoni(DataSource datasource, String schema, String procedureName) {
		super(datasource, schema, procedureName);
		declareParameter(new SqlParameter("in_soc_codice", Types.NUMERIC));
		declareParameter(new SqlParameter("in_username", Types.VARCHAR));
		declareParameter(new SqlParameter("in_srb_ordine", Types.NUMERIC));
		declareParameter(new SqlParameter("in_millesimo", Types.NUMERIC));
		declareParameter(new SqlParameter("in_srb_serie", Types.NUMERIC));
		declareParameter(new SqlOutParameter(OUT_RET_VAL, Types.NUMERIC));
		declareParameter(new SqlOutParameter(OUT_RET_MESSAGE, Types.VARCHAR));
		compile();
	}

	public EsitoSpBean executeProcedure(WebrestDay_AnnullaSerieBuoni webrestDay_AnnullaSerieBuoni) throws RestException {
		logger.debug(webrestDay_AnnullaSerieBuoni);
		EsitoSpBean esitoSpBean = new EsitoSpBean();
		Map<String, Object> out = super.executeProcedure(webrestDay_AnnullaSerieBuoni.getIn_soc_codice(),
				webrestDay_AnnullaSerieBuoni.getIn_username(),
				webrestDay_AnnullaSerieBuoni.getIn_srb_ordine(),
				webrestDay_AnnullaSerieBuoni.getIn_millesimo(),
				webrestDay_AnnullaSerieBuoni.getIn_srb_serie()				
		);
		
		esitoSpBean.setEsito( (BigDecimal) out.get(OUT_RET_VAL));
		esitoSpBean.setMessage((String) out.get(OUT_RET_MESSAGE));
		if(esitoSpBean.getEsito().intValue()!=0) {
			RestException restException = new RestException(null, null, false, false);
			restException.setStatusCode(esitoSpBean.getEsito());
			restException.setStatusMessage(esitoSpBean.getMessage());	
			throw  restException;
		}
		return esitoSpBean;

	}
}
