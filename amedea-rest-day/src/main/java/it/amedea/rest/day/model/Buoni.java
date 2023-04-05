package it.amedea.rest.day.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@IdClass(BuoniId.class)
@Table(schema = "BIRD", name = "BUONI")
public class Buoni {

	@Id
	@Column(name = "BUO_SOC_CODICE")
	private BigDecimal buoSocCodice;
	
	@Id
	@Column(name = "BUO_BUONO")
	private BigDecimal buoBuono;
	
}
