package com.api.cidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cidade.model.PaisModel;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Long> {

}
