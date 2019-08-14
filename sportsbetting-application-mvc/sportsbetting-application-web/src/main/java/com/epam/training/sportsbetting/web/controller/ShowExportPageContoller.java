package com.epam.training.sportsbetting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.web.dto.ExportConfigDto;

@Controller
public class ShowExportPageContoller {

	@ModelAttribute
	public void addExportConfigDto(Model model) {
		model.addAttribute("exportConfig", new ExportConfigDto());
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String getExportDataPage() {
		return "export";
	}

}
