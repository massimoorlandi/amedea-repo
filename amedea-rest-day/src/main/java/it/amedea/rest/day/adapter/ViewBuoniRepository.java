package it.amedea.rest.day.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import it.amedea.rest.day.model.Buoni;
import it.amedea.rest.day.model.BuoniId;

public interface ViewBuoniRepository extends  JpaRepository<Buoni, BuoniId>{

}
