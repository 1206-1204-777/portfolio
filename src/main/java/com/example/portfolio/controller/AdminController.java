	package com.example.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.entity.PortfolioEntity;
import com.example.portfolio.repository.PortfolioRepository;

@Controller
@RequestMapping("/admin/index")
public class AdminController {
	@Autowired
	private PortfolioRepository portfolioRepository;

	//登録情報一覧
	@GetMapping
	public String fileView(Model model) {
		model.addAttribute("procedures", portfolioRepository.findAll());
		return "admin/index";
	}

	//新規登録画面への遷移
	@GetMapping("/new")
	public String newFile(Model model) {
		model.addAttribute("procedures", new PortfolioEntity());
		return "admin/edit_form";
	}

	//新規登録機能
	@PostMapping("/save")
	public String saveFile(@ModelAttribute PortfolioEntity entity) {
		portfolioRepository.save(entity);
		return "redirect:/admin/index";
	}

	//編集
	@GetMapping("/edit/{id}")
	public String editFile(@PathVariable Long id, Model model) {
		model.addAttribute("procedure", portfolioRepository.findById(id).orElse(null));
		return "admin/edit_form";
	}

	//削除
	@GetMapping("/delete/{id}")
	public String daretFile(@PathVariable Long id) {
		portfolioRepository.deleteById(id);
		return "redirect:/admin/index";
	}
}
