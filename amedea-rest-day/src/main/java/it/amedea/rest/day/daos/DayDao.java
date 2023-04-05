package it.amedea.rest.day.daos;

import java.math.BigDecimal;
import java.util.List;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.dtos.WebrestDay_InsCodeline;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;
import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.CodelineArray;

public interface DayDao {
	public BigDecimal getIdCodeline();
	public void insCodeLine(WebrestDay_InsCodeline webrestDay_InsCodeline) throws RestException;
	public EsitoSpBean creaCadhocDay(WebrestDay_CreaCadhocDay webrestDay_CreaCadhocDay) throws RestException;
	public EsitoSpBean annullaSerieBuoni(WebrestDay_AnnullaSerieBuoni serieBuoni) throws RestException;
	public void puliziaBuoni(List<CodelineArray> codelines, List<Buoni> buonis, BigDecimal srbSerie, AvanzamentoOrdiniId id);
	public void deleteByCodeline(String codeLine);
}