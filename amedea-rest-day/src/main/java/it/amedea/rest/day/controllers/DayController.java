package it.amedea.rest.day.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.day.beans.EsitoSpBean;
import it.amedea.rest.day.dtos.WebrestDay_AnnullaSerieBuoni;
import it.amedea.rest.day.dtos.WebrestDay_CreaCadhocDay;

@RequestMapping("/default")
public interface DayController {
	@PostMapping("/create")
	public ResponseEntity<EsitoSpBean> createMealVoucher(@RequestBody WebrestDay_CreaCadhocDay creaCadhocDay) throws RestException;
	@PostMapping("/annulla")
	public ResponseEntity<EsitoSpBean> annullaSerie(@RequestBody WebrestDay_AnnullaSerieBuoni serieBuoni)throws RestException;
}
