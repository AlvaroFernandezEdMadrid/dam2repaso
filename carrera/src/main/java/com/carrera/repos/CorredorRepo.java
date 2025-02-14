package com.carrera.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carrera.models.entities.Corredor;
@Repository
public interface CorredorRepo extends CrudRepository<Corredor, String>{

}
