package it.amedea.rest.day.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "BIRD", name = "SERIE_BUONI")
public class SerieBuoni {

	@Id
	@Column(name = "SRB_SERIE")
	private BigDecimal srbSerie;


}
