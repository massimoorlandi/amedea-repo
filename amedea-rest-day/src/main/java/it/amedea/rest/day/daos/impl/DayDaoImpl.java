package it.amedea.rest.day.daos.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.common.procedures.GetIdCodeline;
import it.amedea.rest.common.utils.DBConstants;
import it.amedea.rest.day.adapter.ViewAvanzamentoOrdiniRepository;
import it.amedea.rest.day.adapter.ViewBuoniRepository;
import it.amedea.rest.day.adapter.ViewCodelineArrayRepository;
import it.amedea.rest.day.adapter.ViewSerieBuoniRepository;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.daos.DayDao;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.dtos.WebrestDay_InsCodeline;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;
import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.CodelineArray;
import it.amedea.rest.day.model.CodelineArrayId;
import it.amedea.rest.day.procedures.SpAnnullaSerieBuoni;
import it.amedea.rest.day.procedures.SpCreaCadhocDay;
import it.amedea.rest.day.procedures.SpInsCodeLine;

@Repository
public class DayDaoImpl implements DayDao {
	private static final Logger logger = LogManager.getLogger(DayDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	ViewBuoniRepository viewBuoniRepository;
	@Autowired
	ViewSerieBuoniRepository viewSerieBuoniRepository;
	@Autowired
	ViewCodelineArrayRepository viewCodelineArrayRepository;
	@Autowired
	ViewAvanzamentoOrdiniRepository viewAvanzamentoOrdiniRepository;
	@Override
	public BigDecimal getIdCodeline() {
		GetIdCodeline getIdCodeline = new GetIdCodeline(dataSource, DBConstants.WEBSVC_ADM_SCHEMA,
				"WEBREST_DAY.GET_ID_CODELINE");
		return getIdCodeline.run();
	}

	@Override
	public void insCodeLine(WebrestDay_InsCodeline webrestDay_InsCodeline) throws RestException {
		SpInsCodeLine spInsCodeLine = new SpInsCodeLine(dataSource, DBConstants.WEBSVC_ADM_SCHEMA,
				"WEBREST_DAY.INS_CODELINE");
		spInsCodeLine.executeProcedure(webrestDay_InsCodeline);
	}

	@Override
	public EsitoSpBean creaCadhocDay(WebrestDay_CreaCadhocDay webrestDay_CreaCadhocDay) throws RestException {
		SpCreaCadhocDay spCreaCadhocDay = new SpCreaCadhocDay(dataSource, DBConstants.WEBSVC_ADM_SCHEMA,
				"WEBREST_DAY.CREA_CADHOC_DAY");
		EsitoSpBean esitoSpBean = spCreaCadhocDay.executeProcedure(webrestDay_CreaCadhocDay);
		return esitoSpBean;
	}

	@Override
	public EsitoSpBean annullaSerieBuoni(WebrestDay_AnnullaSerieBuoni serieBuoni) throws RestException {
		SpAnnullaSerieBuoni spAnnullaSerieBuoni = new SpAnnullaSerieBuoni(dataSource, DBConstants.WEBSVC_ADM_SCHEMA,
				"WEBREST_DAY.ANNULLA_SERIE_BUONI");  
		EsitoSpBean esitoSpBean = spAnnullaSerieBuoni.executeProcedure(serieBuoni);
		return esitoSpBean;
	}

	@Override
	public void deleteByCodeline(String codeLine) {
		jdbcTemplate.update("delete WEBSVC_ADM.CODELINE_ARRAY "
	     + "where CA_CODELINE = ?",
	     codeLine);
	}

	
	@Override
	public void puliziaBuoni(List<CodelineArray> codelines, List<Buoni> buonis, BigDecimal srbSerie, AvanzamentoOrdiniId avanzamentoOrdiniId) {
		for (CodelineArray codeline: codelines) {
			deleteByCodeline(codeline.getCaCodeline());
		}
		viewSerieBuoniRepository.deleteById(srbSerie);
		viewBuoniRepository.deleteAll(buonis);
		viewAvanzamentoOrdiniRepository.deleteById(avanzamentoOrdiniId);
	}

}
