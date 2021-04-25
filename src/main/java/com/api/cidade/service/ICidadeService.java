package com.api.cidade.service;

import java.util.List;

import com.api.cidade.model.CidadeModel;

public interface ICidadeService {

	List<CidadeModel> findAll();

	CidadeModel findById(Long id);
}
