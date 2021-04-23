package com.api.cidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cidade.model.CidadeModel;
import com.api.cidade.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	@GetMapping
	public List<CidadeModel> listar(){
		return cidadeRepository.findAll();
	}
}
