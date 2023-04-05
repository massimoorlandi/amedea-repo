package it.amedea.rest.day.adapter;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import it.amedea.rest.day.model.SerieBuoni;

public interface ViewSerieBuoniRepository extends  JpaRepository<SerieBuoni, BigDecimal>{

}
