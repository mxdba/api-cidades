package com.api.cidade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.cidade.model.CidadeModel;
import com.api.cidade.repository.CidadeRepository;

public class CidadeService implements ICidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepositoryy;
	
	
	@Override
	public List<CidadeModel> findAll() {
		return (List<CidadeModel>) cidadeRepository.findAll();
	}	
}
