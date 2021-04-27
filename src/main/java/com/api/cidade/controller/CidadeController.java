package com.api.cidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cidade.model.CidadeModel;
import com.api.cidade.model.EstadoModel;
import com.api.cidade.model.PaisModel;
import com.api.cidade.payload.DefaultResponse;
import com.api.cidade.service.ICidadeService;
import com.api.cidade.service.IEstadoService;
import com.api.cidade.service.IPaisService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private ICidadeService cidadeService;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private IEstadoService estadoService;

	@GetMapping
	public ResponseEntity<List<CidadeModel>> FinAll() {
		List<CidadeModel> list = cidadeService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CidadeModel> findByid(@PathVariable Long id) {
		CidadeModel cidadeModel = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidadeModel);
	}

	@PostMapping
	public ResponseEntity<CidadeModel> insert(@RequestBody CidadeModel obj) {
		obj = cidadeService.insert(obj);
		return ResponseEntity.ok().body(obj);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cidadeService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/pais")
	public ResponseEntity<List<PaisModel>> FindAll() {
		List<PaisModel> list = paisService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/pais/{id}")
	public ResponseEntity<PaisModel> findByPaisId(@PathVariable Long id) {
		PaisModel paisModel = paisService.findById(id);
		return ResponseEntity.ok().body(paisModel);
	}

	@GetMapping("/estado")
	public ResponseEntity<List<EstadoModel>> FindAllEstado() {
		List<EstadoModel> list = estadoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/estado/{id}")
	public ResponseEntity<EstadoModel> findByEstadoId(@PathVariable Long id) {
		EstadoModel estadoModel = estadoService.findById(id);
		return ResponseEntity.ok().body(estadoModel);
	}

	@GetMapping(value = "/estado/uf/{sigla}")
	public ResponseEntity<DefaultResponse> getCidadeUf(@PathVariable("sigla") String sigla) {
		DefaultResponse response = estadoService.getCidadeUf(sigla);
		return new ResponseEntity<DefaultResponse>(response, response.getStatus());
	}

	@PostMapping("/estado")
	public ResponseEntity<EstadoModel> insertEstado(@RequestBody EstadoModel obj) {
		obj = estadoService.insert(obj);
		return ResponseEntity.ok().body(obj);

	}

	@DeleteMapping("/estado/{id}")
	public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
		estadoService.deleteEstado(id);
		return ResponseEntity.noContent().build();
	}
}
