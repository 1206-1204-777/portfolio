package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.service.PortfolioService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping
public class PortfollioController {
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
	public String listPort(Model model) {
		return "procedures";
		
	}
	@GetMapping("/procedures/{id}")
	public String filePort(Model model) {
		return null;
		
	}
	@GetMapping("/admin/procedures")
	public String admin(Model model) {
		return null;
		
	}
}
