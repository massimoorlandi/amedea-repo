package it.amedea.rest.common.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.amedea.rest.common.services.SystemServiceImpl;


@Controller
public class SystemTestController {

	@Autowired
	SystemServiceImpl systemService;
	
	@GetMapping("/")
	public String getSystemTest(Model model) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{\"status\":\"UP\",");
		stringBuilder.append(String.format("\"time\":\"%s\"}", systemService.getSystemDate()));
		model.addAttribute("sysdate", stringBuilder.toString());
		return "systemView";
	}
}
