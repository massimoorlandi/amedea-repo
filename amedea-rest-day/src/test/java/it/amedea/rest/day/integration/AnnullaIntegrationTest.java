package it.amedea.rest.day.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;
import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.CodelineArray;
import it.amedea.rest.day.services.DayService;

@SpringBootTest
public class AnnullaIntegrationTest {

	@Autowired
	DayService dayService;

	@Test
//	@Disabled
	@DisplayName("annulla: inserimento annulla")
	public void test_when_ok() {
		try {
			clean();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			EsitoSpBean esitoInsert = insertcreateMealVoucher();
		} catch (RestException e) {
			e.printStackTrace();
		}
		EsitoSpBean esitoAnnulla = null;
		try {
			esitoAnnulla = dayService.annullaSerieBuoni(webrestDay_AnnullaSerieBuoni());
			assertEquals(0, esitoAnnulla.esito.intValue());
		} catch (RestException e) {
			e.printStackTrace();
		}
	}

	@Test
//	@Disabled
	@DisplayName("annulla: inserisco annulla annulla")
	public void test_when_doubleInsert() {
		try {
			clean();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			EsitoSpBean esitoInsert = insertcreateMealVoucher();
		} catch (RestException e) {
			e.printStackTrace();
		}
		EsitoSpBean esitoAnnulla = null;
		try {
			esitoAnnulla = dayService.annullaSerieBuoni(webrestDay_AnnullaSerieBuoni());
		} catch (RestException e) {
			e.printStackTrace();
		}
		RestException restException = null;
		try {
			esitoAnnulla = dayService.annullaSerieBuoni(webrestDay_AnnullaSerieBuoni());
		} catch (RestException e) {
			restException = e;
			e.printStackTrace();
		}
		assertEquals(408, restException.getStatusCode().intValue());
		
	}

	
	@Test
//	@Disabled
	@DisplayName("annulla: senza inserimento")
	public void test_when_no_insert() {
		try {
			clean();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		EsitoSpBean esitoAnnulla = null;
		RestException exception = null;
		try {
			esitoAnnulla = dayService.annullaSerieBuoni(webrestDay_AnnullaSerieBuoni_SERIE_INESSTENTE());
		} catch (RestException e) {
			exception = e;
			e.printStackTrace();
		}		
		assertEquals(406, exception.getStatusCode().intValue());
	}

	@Test
//	@Disabled
	@DisplayName("annulla: param wrong")
	public void test_when_wrong() {
		try {
			clean();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		EsitoSpBean esitoAnnulla = null;
		RestException exception = null;
		try {
			esitoAnnulla = dayService.annullaSerieBuoni(webrestDay_AnnullaSerieBuoni_WRONG());
		} catch (RestException e) {
			exception = e;
			e.printStackTrace();
		}		
		assertEquals(405, exception.getStatusCode().intValue());
	}


	private WebrestDay_AnnullaSerieBuoni webrestDay_AnnullaSerieBuoni_SERIE_INESSTENTE() {
		WebrestDay_AnnullaSerieBuoni serieBuoni = new WebrestDay_AnnullaSerieBuoni();
		serieBuoni.setIn_soc_codice(new BigDecimal(6));
		serieBuoni.setIn_username("MORLANDI");
		serieBuoni.setIn_srb_ordine(new BigDecimal(9412));
		serieBuoni.setIn_millesimo(new BigDecimal(21));
		serieBuoni.setIn_srb_serie(new BigDecimal(-1));
				
		return serieBuoni; 
	}

	private WebrestDay_AnnullaSerieBuoni webrestDay_AnnullaSerieBuoni_WRONG() {
		WebrestDay_AnnullaSerieBuoni serieBuoni = new WebrestDay_AnnullaSerieBuoni();
		serieBuoni.setIn_soc_codice(new BigDecimal(6));
		serieBuoni.setIn_username("MORLANDI");
		serieBuoni.setIn_srb_ordine(new BigDecimal(9412));
		serieBuoni.setIn_millesimo(new BigDecimal(21));
		serieBuoni.setIn_srb_serie(null);
		
		return serieBuoni; 
	}



	
	private WebrestDay_AnnullaSerieBuoni webrestDay_AnnullaSerieBuoni() {
		WebrestDay_AnnullaSerieBuoni serieBuoni = new WebrestDay_AnnullaSerieBuoni();
		serieBuoni.setIn_soc_codice(new BigDecimal(6));
		serieBuoni.setIn_username("MORLANDI");
		serieBuoni.setIn_srb_ordine(new BigDecimal(9412));
		serieBuoni.setIn_millesimo(new BigDecimal(21));
		serieBuoni.setIn_srb_serie(new BigDecimal(88256575));
				
		return serieBuoni; 
	}
	
	private EsitoSpBean insertcreateMealVoucher() throws RestException {
		WebrestDay_CreaCadhocDay creaCadhocDay = new WebrestDay_CreaCadhocDay();
		creaCadhocDay.setIn_soc_codice(new BigDecimal(6));
		creaCadhocDay.setIn_username("MORLANDI");
		creaCadhocDay.setIn_srb_ordine(new BigDecimal(9412));
		creaCadhocDay.setIn_millesimo(new BigDecimal(21));
		creaCadhocDay.setIn_srb_serie(new BigDecimal(88256575));
		creaCadhocDay.setIn_prd_codice(new BigDecimal(0));
		creaCadhocDay.setIn_data_scad("20221231");
		creaCadhocDay.setIn_data_scad_util("20221231");
		creaCadhocDay.setIn_tipo_prodotto("43");
		creaCadhocDay.setIn_valore_facciale("2500");
		creaCadhocDay.setIn_valore_ris(null);
		creaCadhocDay.setIn_rete("0");
		creaCadhocDay.setIn_cliente("108926");
		List<String> list = new ArrayList<String>();
		list.add("61222564763004300004062814102500");
		list.add("61222564771004300009062714702500");
		list.add("61222564788004300009062714702500");
		creaCadhocDay.setListCodeline(list);
		return dayService.createMealVoucher(creaCadhocDay);
	}

	private void clean() {
		List<CodelineArray> codelines = new ArrayList<CodelineArray>();
		CodelineArray codelineArray0 = new CodelineArray();
		codelineArray0.setCaCodeline("61222564763004300004062814102500");
		CodelineArray codelineArray1 = new CodelineArray();
		codelineArray1.setCaCodeline("61222564771004300009062714702500");
		CodelineArray codelineArray2 = new CodelineArray();
		codelineArray2.setCaCodeline("61222564788004300009062714702500");
		codelines.add(codelineArray0);
		codelines.add(codelineArray1);
		codelines.add(codelineArray2);
		
		BigDecimal srbSerie = new BigDecimal(88256575);
		
		List<Buoni> buonis = new ArrayList<Buoni>();
		Buoni buoni0 = new Buoni();
		buoni0.setBuoSocCodice(new BigDecimal(6));
		buoni0.setBuoBuono(new BigDecimal("6122256476"));
		Buoni buoni1 = new Buoni();
		buoni1.setBuoSocCodice(new BigDecimal(6));
		buoni1.setBuoBuono(new BigDecimal("6122256477"));
		Buoni buoni2 = new Buoni();
		buoni2.setBuoSocCodice(new BigDecimal(6));
		buoni2.setBuoBuono(new BigDecimal("6122256478"));
		buonis.add(buoni0);
		buonis.add(buoni1);
		buonis.add(buoni2);
		
		AvanzamentoOrdiniId avanzamentoOrdiniId = new AvanzamentoOrdiniId();
		avanzamentoOrdiniId.setAvoSocCodice(new BigDecimal(6));
		avanzamentoOrdiniId.setAvoAvpNumero(new BigDecimal(0));
		avanzamentoOrdiniId.setAvoOrdNumero(new BigDecimal(9412));
		avanzamentoOrdiniId.setAvoMillesimo(new BigDecimal(21));
		
		dayService.puliziaBuoni(codelines, buonis, srbSerie, avanzamentoOrdiniId);
	}

}
