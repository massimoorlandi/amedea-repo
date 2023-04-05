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
@IdClass(AvanzamentoOrdiniId.class)
@Table(schema = "BIRD", name = "AVANZAMENTO_ORDINI")
public class AvanzamentoOrdini {
	@Id
	@Column(name = "avo_soc_codice")
	BigDecimal avoSocCodice;
	@Id
	@Column(name = "avo_avp_numero")
	BigDecimal avoAvpNumero;
	@Id
	@Column(name = "avo_ord_numero")
	BigDecimal avoOrdNumero;
	@Id
	@Column(name = "avo_millesimo")
	BigDecimal avoMillesimo;
}
