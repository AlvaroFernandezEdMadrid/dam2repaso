package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.dam2.examencarrera.configuracion.DtoConverter;
import org.dam2.examencarrera.modelo.dto.CarreraConPCDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.repositorio.CarreraCorredorRepositorio;
import org.dam2.examencarrera.repositorio.CarreraRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServicioImpl implements ICarreraServicio {

	@Autowired private CarreraRepositorio carreraDAO;

	@Autowired private DtoConverter dtoConverter;

	@Override
	public boolean insertar(CarreraConPCDto carrera) {
		boolean exito = false;

		if (!carreraDAO.existsById(carrera.getNombre()))
			carreraDAO.save(carreraConPCD2Carrera(carrera));

		return exito;
	}
	@Override
	public boolean tienePlazasLibres(String nombre) {
		boolean hayPlazas = false;

		if (carreraDAO.existsById(nombre))
		{
			if (carreraDAO.cuantosInscritos(nombre) < carreraDAO.maximoPermintido(nombre))
				hayPlazas = true;
		}

		return hayPlazas;
	}
	@Override
	public List<CarreraDto> findAll() {
		return dtoConverter.
				mapAll((List<Carrera>) carreraDAO.findAll(), 
						CarreraDto.class);
	}
	@Override
	public Optional<CarreraDto> findByNombre(String nombre) {
		return carreraDAO.findById(nombre).
				map(c -> dtoConverter.map(c, CarreraDto.class));
	}

	@Override
	public List<CorredorDto> obtenerCorredores(String nombre) {
		return dtoConverter.mapAll(
				carreraDAO.corredoresPorCarrera(nombre), 
				CorredorDto.class);
	}
	@Override
	public List<CarreraDto> carrerasDisponiblesPorCorredor(String dni) {		
		return dtoConverter.mapAll(
				carreraDAO.carrerasDisponiblesPorCorredor(dni), 
				CarreraDto.class);
	}
	@Override
	public List<CorredorDto> clasificacionCarreraMasAntigua() {
		
		return dtoConverter.mapAll(
				carreraDAO.clasificacionCarreraMasAntigua (), 
				CorredorDto.class);
	}

	private Carrera carreraConPCD2Carrera (CarreraConPCDto cDto)
	{
		return dtoConverter.map(cDto, Carrera.class);
	}

}
