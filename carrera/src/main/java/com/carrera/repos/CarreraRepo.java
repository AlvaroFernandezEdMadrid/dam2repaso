package com.carrera.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carrera.models.entities.Carrera;
@Repository
public interface CarreraRepo extends CrudRepository<Carrera, String>{

}
