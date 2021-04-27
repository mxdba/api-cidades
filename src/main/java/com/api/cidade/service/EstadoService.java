package com.api.cidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.cidade.exception.DefaultApiException;
import com.api.cidade.model.EstadoModel;
import com.api.cidade.payload.DefaultResponse;
import com.api.cidade.repository.EstadoRepository;

@Service
public class EstadoService implements IEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<EstadoModel> findAll() {
		try {
			return (List<EstadoModel>) estadoRepository.findAll();
		} catch (Exception e) {
			throw new DefaultApiException(e.getMessage(), e, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public EstadoModel findById(Long id) {
		Optional<EstadoModel> obj = estadoRepository.findById(id);
		return obj.get();
	}

	@Override
	public EstadoModel insert(EstadoModel obj) {
		return estadoRepository.save(obj);
	}

	@Override
	public void deleteEstado(Long id) {
		estadoRepository.deleteById(id);
	}
	
	private boolean checkValidaEstado(String sigla) {
		boolean result = false;
		
		if (sigla == null || sigla.isEmpty() || sigla.length() != 2) {
			result = true;
		}
		
		switch (sigla.toUpperCase()) {
			case "AC":
			case "AL":
			case "AP":
			case "AM":
			case "BA":
			case "CE":
			case "DF":
			case "ES":
			case "GO":
			case "MA":
			case "MT":
			case "MS":
			case "MG":
			case "PA":
			case "PB":
			case "PR":
			case "PE":
			case "PI":
			case "RJ":
			case "RN":
			case "RS":
			case "RO":
			case "RR":
			case "SC":
			case "SP":
			case "SE":
			case "TO":
				result = false;
			break;
			default:
				result = true;
				break;
		}
		
		return result;
	}
	@Override
	public DefaultResponse getCidadeUf(String sigla) {
		try {
			if (checkValidaEstado(sigla)) {
				throw new DefaultApiException("O parâmetro uf está inválido.", HttpStatus.BAD_REQUEST);
			}
			
			List<Object> list = estadoRepository.getCidadeUf(sigla.toUpperCase());
			
			HttpStatus status = HttpStatus.OK;
			if (list.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
			}
			DefaultResponse response = new DefaultResponse(status, "application/json", Long.valueOf(list.size()), list);
			return response;
		} catch (Exception e) {
			throw new DefaultApiException(e.getMessage(), e, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
