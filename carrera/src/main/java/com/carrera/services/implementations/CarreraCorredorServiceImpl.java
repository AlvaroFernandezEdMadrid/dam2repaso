package com.carrera.services.implementations;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrera.config.DtoConverter;
import com.carrera.models.dto.CarreraCorredorDto;
import com.carrera.repos.CarreraCorredorRepo;
import com.carrera.services.interfaces.ICarreraCorredorService;
@Service
public class CarreraCorredorServiceImpl implements ICarreraCorredorService {
	
	@Autowired private CarreraCorredorRepo carreraCorredor;
	@Autowired private DtoConverter dtoConverter;

	@Override
	public boolean anotarTiempoCorredorCarrera(CarreraCorredorDto carreraCorredorDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<CarreraCorredorDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
