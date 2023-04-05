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
@IdClass(CodelineArrayId.class)
@Table(schema = "WEBSVC_ADM", name = "CODELINE_ARRAY")
public class CodelineArray {
	
	@Id
	@Column(name = "CA_ID")
	private BigDecimal caId;

	@Id
	@Column(name = "CA_CODELINE")
	private String caCodeline;

}
