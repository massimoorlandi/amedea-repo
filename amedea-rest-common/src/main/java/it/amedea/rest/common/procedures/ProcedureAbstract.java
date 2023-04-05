package it.amedea.rest.common.procedures;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.object.StoredProcedure;

public abstract class ProcedureAbstract extends StoredProcedure {

	private static final Logger log = LogManager.getLogger(ProcedureAbstract.class);
    public static final int RESULT_PROCEDURE_OK = 0;
    public static final int RESULT_PROCEDURE_ERROR = 1;
	public static final String OUT_RET_VAL = "outRetVal";
	public static final String OUT_RET_MESSAGE = "outRetMessage";

	protected String procedureName;

	protected ProcedureAbstract(DataSource datasource, String schema, String procedureName){
		super(datasource, schema + "." + procedureName);
		this.procedureName = procedureName;
	}

	protected Map<String, Object> executeProcedure(Object... inParams) {
		Map<String, Object> out = null;
		try {
			out = execute(inParams);
			checkProcedureStatus(out);
			return out;
		} catch(SQLException e) {
			log.error(e, e);
		}
		return out;
	}

	private void checkProcedureStatus(Map<String, Object> results) throws SQLException {
		int pResult = ((BigDecimal) results.get(OUT_RET_VAL)).intValue();
		if(pResult >= RESULT_PROCEDURE_ERROR){
			String pResultDescr = (String) results.get(OUT_RET_MESSAGE);
			throw new SQLException("Error in procedure " + this.procedureName + ": " + pResultDescr);
		}
	}

}