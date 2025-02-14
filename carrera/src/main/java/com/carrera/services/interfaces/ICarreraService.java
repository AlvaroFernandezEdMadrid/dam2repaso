package com.carrera.services.interfaces;

import java.util.Optional;
import java.util.Set;

import com.carrera.models.dto.CarreraDto;
import com.carrera.models.dto.CorredorDto;

public interface ICarreraService {
	public boolean insert(CarreraDto carrera); 
	public boolean tienePlazasLibres(String nombre);
	public Set<CarreraDto> findAll();
	public Optional<CarreraDto> findByNombre(String nombre);
	public Set<CorredorDto> obtenerCorredores(String nombre);
}
