package com.api.cidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.cidade.model.EstadoModel;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

	@Query(value = "select nome from estado where sigla = :sigla order by nome", nativeQuery = true)
	List<Object> getCidadeUf(String sigla);
	
}
