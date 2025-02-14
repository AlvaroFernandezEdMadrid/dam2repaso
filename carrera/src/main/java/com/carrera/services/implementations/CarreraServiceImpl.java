package com.carrera.services.implementations;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrera.config.DtoConverter;
import com.carrera.models.dto.CarreraDto;
import com.carrera.models.dto.CorredorDto;
import com.carrera.models.entities.Carrera;
import com.carrera.models.entities.Corredor;
import com.carrera.repos.CarreraRepo;
import com.carrera.services.interfaces.ICarreraService;
@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired private CarreraRepo carreraDAO;
	@Autowired private DtoConverter dtoConverter;
	
	@Override
	public boolean insert(CarreraDto carrera) {
		boolean exito=false;
		
		if (!carreraDAO.existsById(carrera.getNombre())) {
			carreraDAO.save(dtoConverter.map(carrera, Carrera.class));
			exito=true;
		}
		
		return exito;
	}

	@Override
	public boolean tienePlazasLibres(String nombre) {
		
		return false;
	}

	@Override
	public Set<CarreraDto> findAll() {
		
		return null;
	}

	@Override
	public Optional<CarreraDto> findByNombre(String nombre) {
		
		return Optional.empty();
	}

	@Override
	public Set<CorredorDto> obtenerCorredores(String nombre) {
		
		return null;
	}

}
