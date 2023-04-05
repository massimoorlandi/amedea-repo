package it.amedea.rest.day.dtos;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class WebrestDay_AnnullaSerieBuoni {

   private BigDecimal in_soc_codice;

   private String in_username;

   private BigDecimal in_srb_ordine;

   private BigDecimal in_millesimo;

   private BigDecimal in_srb_serie;

   private BigDecimal ret_val;

   private String ret_message;

   @Override
   public String toString() { 
	   return "{\"in_soc_codice\":\""+in_soc_codice+"\",\"in_username\":\""+in_username+"\",\"in_srb_ordine\":\""+in_srb_ordine+"\",\"in_millesimo\":\""+in_millesimo+"\",\"in_srb_serie\":\""+in_srb_serie+"\",\"ret_val\":\""+ret_val+"\",\"ret_message\":\""+ret_message+"\"}";
   }
}
