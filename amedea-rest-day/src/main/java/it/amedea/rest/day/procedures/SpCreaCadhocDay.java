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
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;

public class SpCreaCadhocDay extends ProcedureAbstract {
	private static final Logger logger = LogManager.getLogger(SpCreaCadhocDay.class);
	public SpCreaCadhocDay(DataSource datasource, String schema, String procedureName) {
		super(datasource, schema, procedureName);
		declareParameter(new SqlParameter("in_soc_codice", Types.NUMERIC));
		declareParameter(new SqlParameter("in_username", Types.VARCHAR));
		declareParameter(new SqlParameter("in_srb_ordine", Types.NUMERIC));
		declareParameter(new SqlParameter("in_millesimo", Types.NUMERIC));
		declareParameter(new SqlParameter("in_srb_serie", Types.NUMERIC));
		declareParameter(new SqlParameter("in_id_codeline_array", Types.NUMERIC));
		declareParameter(new SqlParameter("in_prd_codice", Types.NUMERIC));
		declareParameter(new SqlParameter("in_data_scad", Types.VARCHAR));
		declareParameter(new SqlParameter("in_data_scad_util", Types.VARCHAR));
		declareParameter(new SqlParameter("in_tipo_prodotto", Types.VARCHAR));
		declareParameter(new SqlParameter("in_valore_facciale", Types.VARCHAR));
		declareParameter(new SqlParameter("in_valore_ris", Types.VARCHAR));
		declareParameter(new SqlParameter("in_rete", Types.VARCHAR));
		declareParameter(new SqlParameter("in_cliente", Types.VARCHAR));
		declareParameter(new SqlOutParameter(OUT_RET_VAL, Types.NUMERIC));
		declareParameter(new SqlOutParameter(OUT_RET_MESSAGE, Types.VARCHAR));
		compile();
	}

	public EsitoSpBean executeProcedure(WebrestDay_CreaCadhocDay webrestDay_CreaCadhocDay) throws RestException  {
		logger.debug(webrestDay_CreaCadhocDay.toString());
		EsitoSpBean esitoSpBean = new EsitoSpBean();
		Map<String, Object> out = super.executeProcedure(webrestDay_CreaCadhocDay.getIn_soc_codice(),
				webrestDay_CreaCadhocDay.getIn_username(),
				webrestDay_CreaCadhocDay.getIn_srb_ordine(),
				webrestDay_CreaCadhocDay.getIn_millesimo(),
				webrestDay_CreaCadhocDay.getIn_srb_serie(),
				webrestDay_CreaCadhocDay.getIn_id_codeline_array(),
				webrestDay_CreaCadhocDay.getIn_prd_codice(),
				webrestDay_CreaCadhocDay.getIn_data_scad(),
				webrestDay_CreaCadhocDay.getIn_data_scad_util(),
				webrestDay_CreaCadhocDay.getIn_tipo_prodotto(),
				webrestDay_CreaCadhocDay.getIn_valore_facciale(),
				webrestDay_CreaCadhocDay.getIn_valore_ris(),
				webrestDay_CreaCadhocDay.getIn_rete(),
				webrestDay_CreaCadhocDay.getIn_cliente()
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
