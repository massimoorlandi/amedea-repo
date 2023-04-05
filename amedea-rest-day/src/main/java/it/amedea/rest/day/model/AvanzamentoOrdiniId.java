package it.amedea.rest.day.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AvanzamentoOrdiniId implements Serializable{
	
	BigDecimal avoSocCodice;
	BigDecimal avoAvpNumero;
	BigDecimal avoOrdNumero;
	BigDecimal avoMillesimo;
}
