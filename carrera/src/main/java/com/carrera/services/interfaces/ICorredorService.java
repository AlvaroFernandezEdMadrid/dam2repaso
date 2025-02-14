package com.carrera.services.interfaces;

import java.util.Optional;
import java.util.Set;

import com.carrera.models.dto.CorredorDto;

public interface ICorredorService {
	public boolean insert(CorredorDto corredor);
	public Set<CorredorDto> findAll();
	public Optional<CorredorDto>  findByDni(String dni);
	
}
