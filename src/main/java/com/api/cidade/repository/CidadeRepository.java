package com.api.cidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cidade.model.CidadeModel;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {

}
