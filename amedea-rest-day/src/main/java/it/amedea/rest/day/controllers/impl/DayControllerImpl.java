package it.amedea.rest.day.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.controllers.DayController;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;
import it.amedea.rest.day.services.DayService;

@RestController
@RequestMapping("day/meal_voucher")
public class DayControllerImpl implements DayController{
	
	private final DayService dayService;
	
	public DayControllerImpl(DayService dayService) {
		this.dayService = dayService;
	}
	
	@Override
	public ResponseEntity<EsitoSpBean> createMealVoucher(WebrestDay_CreaCadhocDay creaCadhocDay) throws RestException {		
		EsitoSpBean esito = dayService.createMealVoucher(creaCadhocDay);
		return ResponseEntity.ok(esito);
	}

	@Override
	public ResponseEntity<EsitoSpBean> annullaSerie(WebrestDay_AnnullaSerieBuoni serieBuoni) throws RestException{
		EsitoSpBean esito  = this.dayService.annullaSerieBuoni(serieBuoni);
		return ResponseEntity.ok(esito);
	}

	
	

}
