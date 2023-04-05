package it.amedea.rest.day.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import it.amedea.rest.day.model.AvanzamentoOrdini;
import it.amedea.rest.day.model.AvanzamentoOrdiniId;

public interface ViewAvanzamentoOrdiniRepository extends  JpaRepository<AvanzamentoOrdini, AvanzamentoOrdiniId>{

}
