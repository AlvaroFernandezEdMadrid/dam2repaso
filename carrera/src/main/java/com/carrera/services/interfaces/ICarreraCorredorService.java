package com.carrera.services.interfaces;

import java.util.Set;

import com.carrera.models.dto.CarreraCorredorDto;

public interface ICarreraCorredorService {
	public boolean anotarTiempoCorredorCarrera(CarreraCorredorDto carreraCorredorDto);
	public Set<CarreraCorredorDto> findAll();
}
