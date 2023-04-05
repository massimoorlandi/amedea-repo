package it.amedea.rest.day.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WebrestDay_CreaCadhocDay {

	private BigDecimal in_soc_codice;

	private String in_username;

	private BigDecimal in_srb_ordine;

	private BigDecimal in_millesimo;

	private BigDecimal in_srb_serie;

	private BigDecimal in_id_codeline_array; //*

	private BigDecimal in_prd_codice;

	private String in_data_scad;

	private String in_data_scad_util;

	private String in_tipo_prodotto;

	private String in_valore_facciale;

	private String in_valore_ris;

	private String in_rete;

	private String in_cliente;

	private BigDecimal ret_val;

	private String ret_message;

	private List<String> listCodeline;

	
	@Override
	public String toString() {
		return "{\"in_soc_codice\":\"" + in_soc_codice + "\",\"in_username\":\"" + in_username
				+ "\",\"in_srb_ordine\":\"" + in_srb_ordine + "\",\"in_millesimo\":\"" + in_millesimo
				+ "\",\"in_srb_serie\":\"" + in_srb_serie + "\",\"in_id_codeline_array\":\"" + in_id_codeline_array
				+ "\",\"in_prd_codice\":\"" + in_prd_codice + "\",\"in_data_scad\":\"" + in_data_scad
				+ "\",\"in_data_scad_util\":\"" + in_data_scad_util + "\",\"in_tipo_prodotto\":\"" + in_tipo_prodotto
				+ "\",\"in_valore_facciale\":\"" + in_valore_facciale + "\",\"in_valore_ris\":\"" + in_valore_ris
				+ "\",\"in_rete\":\"" + in_rete + "\",\"in_cliente\":\"" + in_cliente + "\",\"ret_val\":\"" + ret_val
				+ "\",\"ret_message\":\"" + ret_message + "\"}";
	}
}