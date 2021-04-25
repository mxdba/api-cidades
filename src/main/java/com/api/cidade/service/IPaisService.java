package com.api.cidade.service;

import java.util.List;

import com.api.cidade.model.PaisModel;

public interface IPaisService {

	List<PaisModel> findAll();

	PaisModel findById(Long id);
}
