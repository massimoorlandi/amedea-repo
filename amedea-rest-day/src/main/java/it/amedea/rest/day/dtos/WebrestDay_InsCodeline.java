package it.amedea.rest.day.dtos;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class WebrestDay_InsCodeline {

	private BigDecimal in_id;

	private String in_codeline;

	private BigDecimal out_ret_val;

	private String out_ret_message;

	public WebrestDay_InsCodeline() {
	}
	
	public WebrestDay_InsCodeline(BigDecimal id, String codeline) {
		this.in_id = id;
		this.in_codeline = codeline;
	}


	@Override
	public String toString() {
		return "{\"in_id\":\"" + in_id + "\",\"in_codeline\":\"" + in_codeline + "\",\"out_ret_val\":\"" + out_ret_val
				+ "\",\"out_ret_message\":\"" + out_ret_message + "\"}";
	}
}
