package it.amedea.rest.day.services;

import java.math.BigDecimal;
import java.util.List;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;
import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.CodelineArray;

public interface DayService {
	public EsitoSpBean createMealVoucher(WebrestDay_CreaCadhocDay creaCadhocDay) throws RestException;
	public EsitoSpBean annullaSerieBuoni(WebrestDay_AnnullaSerieBuoni serieBuoni) throws RestException;
	public void puliziaBuoni(List<CodelineArray> codelines, List<Buoni> buonis, BigDecimal srbSerie, AvanzamentoOrdiniId avanzamentoOrdiniId);
}
