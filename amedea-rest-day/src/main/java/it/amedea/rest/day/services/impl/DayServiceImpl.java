package it.amedea.rest.day.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.daos.DayDao;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.dtos.WebrestDay_InsCodeline;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;
import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.CodelineArray;
import it.amedea.rest.day.services.DayService;

@Service
@Transactional
public class DayServiceImpl implements DayService{
	private static final Logger logger = LogManager.getLogger(DayServiceImpl.class);

	private final DayDao dao;
	
	public DayServiceImpl(DayDao dao) {
		this.dao = dao;
	}

	@Override
	public EsitoSpBean createMealVoucher(WebrestDay_CreaCadhocDay creaCadhocDay) throws RestException {
		EsitoSpBean esitoSpBean = null; 
		BigDecimal id = dao.getIdCodeline();
		if(creaCadhocDay.getListCodeline()!=null) {
			for(String codeline:creaCadhocDay.getListCodeline()) {
				WebrestDay_InsCodeline insCodeline = new WebrestDay_InsCodeline(id,codeline);
					dao.insCodeLine(insCodeline);
			}			
		}
		creaCadhocDay.setIn_id_codeline_array(id);
		esitoSpBean = dao.creaCadhocDay(creaCadhocDay);
		logger.info("creaCadhocDay eseguita correttamente");
		return esitoSpBean;
	}

	@Override
	public EsitoSpBean annullaSerieBuoni(WebrestDay_AnnullaSerieBuoni serieBuoni) throws RestException {
		return dao.annullaSerieBuoni(serieBuoni);
	}

	@Override
	public void puliziaBuoni(List<CodelineArray> codelines, List<Buoni> buonis, BigDecimal srbSerie, AvanzamentoOrdiniId avanzamentoOrdiniId) {
		dao.puliziaBuoni(codelines, buonis, srbSerie, avanzamentoOrdiniId);
	}
	
}
