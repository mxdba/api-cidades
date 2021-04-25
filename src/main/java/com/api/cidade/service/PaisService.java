package com.api.cidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.cidade.exception.DefaultApiException;
import com.api.cidade.model.PaisModel;
import com.api.cidade.repository.PaisRepository;

@Service
public class PaisService implements IPaisService {

	@Autowired
	private PaisRepository paisRepository;

	@Override
	public List<PaisModel> findAll() {
		try {
			return (List<PaisModel>) paisRepository.findAll();
		} catch (Exception e) {
			throw new DefaultApiException(e.getMessage(), e, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public PaisModel findById(Long id) {
		Optional<PaisModel> obj = paisRepository.findById(id);
		return obj.get();
	}
}
