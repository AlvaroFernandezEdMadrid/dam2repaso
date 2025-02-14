package com.carrera.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrera.config.DtoConverter;
import com.carrera.models.dto.CorredorDto;
import com.carrera.models.entities.Corredor;
import com.carrera.repos.CorredorRepo;
import com.carrera.services.interfaces.ICorredorService;
@Service
public class CorredorServiceImpl implements ICorredorService {

	@Autowired private CorredorRepo corredorDAO;
	@Autowired private DtoConverter dtoConverter;
	
	@Override
	public boolean insert(CorredorDto corredor) {
		boolean exito = false;
		
		if (!corredorDAO.existsById(corredor.getDni())) {
			corredorDAO.save(dtoConverter.map(corredor, Corredor.class));
			exito=true;
		}
		
		
		return exito;
	}

	@Override
	public Set<CorredorDto> findAll() {
		
		Set<CorredorDto> corredores;
		List<CorredorDto> lista=dtoConverter.mapAll((List<Corredor>)corredorDAO.findAll(),CorredorDto.class);
		
		corredores = lista.stream().collect(Collectors.toSet());
		
		return corredores;
		
	}

	@Override
	public Optional<CorredorDto> findByDni(String dni) {
		return corredorDAO.findById(dni).map(c->dtoConverter.map(c, CorredorDto.class));
	}

}
