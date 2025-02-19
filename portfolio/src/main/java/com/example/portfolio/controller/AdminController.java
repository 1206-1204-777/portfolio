package com.example.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.repository.PortfolioRepository;

@Controller
@RequestMapping("/admin/index")
public class AdminController {
	@Autowired
	private PortfolioRepository portfolioRepository;
	//登録情報一覧
	@GetMapping
	public String fileView(Model model) {
		return "admin/index";
	}
	//新規登録画面への遷移
	@GetMapping("/new")
	public String newFile(Model model) {
		return "admin/index_form";
	}
	//新規登録機能
	@GetMapping("/save")
	public String saveFile(Model model) {
		return "redirect:admin/index";
	}
	
	//編集
	@GetMapping("/edit/{id}")
	public String editFile(Model model,PortfolioRepository repository) {
		return null;
	}
	//削除
	@GetMapping("/delete/{id}")
	public String daretFile(Model model,PortfolioRepository repository) {
		return null;
	}
}
