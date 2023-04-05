package it.amedea.rest.day.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class BuoniId implements Serializable{
	BigDecimal buoSocCodice;
	BigDecimal buoBuono;
}
