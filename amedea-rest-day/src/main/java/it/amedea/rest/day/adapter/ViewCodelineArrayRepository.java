package it.amedea.rest.day.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.amedea.rest.day.model.CodelineArray;
import it.amedea.rest.day.model.CodelineArrayId;

public interface ViewCodelineArrayRepository extends  JpaRepository<CodelineArray, CodelineArrayId>{
	@Query(value = "DELETE from CodelineArray a where a.caCodeline=:codeline", nativeQuery = true)
	void deleteByCodeline(@Param("codeline")String codeline);
}
