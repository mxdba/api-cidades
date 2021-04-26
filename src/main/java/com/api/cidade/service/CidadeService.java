package com.api.cidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.cidade.exception.DefaultApiException;
import com.api.cidade.model.CidadeModel;
import com.api.cidade.repository.CidadeRepository;

@Service
public class CidadeService implements ICidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public List<CidadeModel> findAll() {
		try {
			return (List<CidadeModel>) cidadeRepository.findAll();
		} catch (Exception e) {
			throw new DefaultApiException(e.getMessage(), e, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public CidadeModel findById(Long id) {
		Optional<CidadeModel> obj = cidadeRepository.findById(id);
		return obj.get();
	}
	
	@Override
	public CidadeModel insert(CidadeModel obj) {
	   return cidadeRepository.save(obj);
	}
	
	@Override
	public void delete(Long id) {
		cidadeRepository.deleteById(id);
		
	}
	
}
