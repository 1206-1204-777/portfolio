package com.example.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.entity.PortfolioEntity;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.service.PortfolioService;

@Controller
@RequestMapping
public class PortfollioController {
	@Autowired
	private PortfolioRepository portfolioRepository;
	private PortfolioService portforioService;
	//引数にはサービスとリポジトリを記述
	public void PortfolioController(PortfolioRepository portfolioRepository,PortfolioService portfolioService) {
		this.portfolioRepository = portfolioRepository;
		this.portforioService = portfolioService;
	}
	
	@GetMapping("/")
	public String topPort(Model model) {
		return "index";
		
	}
	@GetMapping("/procedures")
	public String showProcedures(Model model) {
	    List<PortfolioEntity> procedures = portfolioRepository.findAll();
	    model.addAttribute("procedures", procedures);
	    return "procedures";
	}

	@GetMapping("/procedures/{id}")
	public String fileView(@PathVariable Long id, Model model) {
		model.addAttribute("procedure",portfolioRepository.findById(id).orElse(null));
		return "procedure_datail";
		
	}
	@GetMapping("/admin/procedures")
	public String admin(Model model) {
		return null;
		
	}
}
