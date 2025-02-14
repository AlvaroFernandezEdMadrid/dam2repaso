package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.dam2.examencarrera.configuracion.DtoConverter;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.repositorio.CorredorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorServicioImpl implements ICorredorServicio {

	@Autowired 
	private CorredorRepositorio corredorDAO;
	@Autowired
	private DtoConverter dtoConverter;
	
	@Override
	public boolean insertar(CorredorDto corredor) {
		boolean exito = false;
		
		if (!corredorDAO.existsById(corredor.getDni()))
			corredorDAO.save(dtoConverter.map(corredor, Corredor.class));
		
		
		return exito;
	}
	@Override
	public List<CorredorDto> findAll() {
		return dtoConverter.
				mapAll((List<Corredor>)corredorDAO.findAll(), 
						CorredorDto.class);
	}
	@Override
	public Optional<CorredorDto> findByDNI(String dni) {
		return corredorDAO.findById(dni).
				map(c -> dtoConverter.map(c, CorredorDto.class));
	}

	
	
}
