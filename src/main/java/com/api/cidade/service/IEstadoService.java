package com.api.cidade.service;

import java.util.List;

import com.api.cidade.model.EstadoModel;
import com.api.cidade.payload.DefaultResponse;

public interface IEstadoService {

	List<EstadoModel> findAll();

	EstadoModel findById(Long id);
	
	EstadoModel insert(EstadoModel obj);
	
	void deleteEstado(Long id);
	
	DefaultResponse getCidadeUf(String sigla);
}
