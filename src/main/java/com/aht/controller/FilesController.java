package com.aht.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.service.CsvService;

@Controller
public class FilesController {
	@Autowired
	private CsvService cService;

	@RequestMapping(value = { "/" })
	public String index(Model model) {
		model.addAttribute("msg1", "aaaa");

		return "index";
	}

	@RequestMapping(value = { "/upload-file" })
	public String uploadFile(@RequestParam("path") String path, Model model) {
		try {
			cService.readCSV(path);
			model.addAttribute("msg", "Success!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", "Fail!!!");
			e.printStackTrace();
		}
		return "index";
	}

}
