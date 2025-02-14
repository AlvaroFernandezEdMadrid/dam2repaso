package com.carrera.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carrera.models.entities.CarreraCorredor;
@Repository
public interface CarreraCorredorRepo extends CrudRepository<CarreraCorredor, String>{

}
