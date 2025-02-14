package org.dam2.examencarrera.servicio;

import java.util.List;

import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;


public interface ICarreraCorredorServicio {
	public int insertarCorredorCarrera (CarreraConCorredorCompletoDto carreraCorredorDto);
	public boolean anotarTiempoCorredorCarrera (CarreraCorredorDto carreraCorredorDto);
	public List<CarreraCorredorDto> findAll();

}
