package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.configuracion.DtoConverter;
import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.repositorio.CarreraCorredorRepositorio;
import org.dam2.examencarrera.repositorio.CarreraRepositorio;
import org.dam2.examencarrera.repositorio.CorredorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraCorredorServiceImpl implements ICarreraCorredorServicio {

	@Autowired private CorredorRepositorio corredorDAO;
	@Autowired private CarreraRepositorio carreraDAO;
	@Autowired private CarreraCorredorRepositorio carreraCorredorDAO;

	@Autowired private DtoConverter dtoConverter;

	@Transactional(rollbackFor = RollBackException.class)
	@Override
	public int insertarCorredorCarrera(CarreraConCorredorCompletoDto carreraCorredorDto) {
		int dorsal = -1;
		CarreraCorredor cc;
		Corredor corredor = dtoConverter.map(carreraCorredorDto.getCorredor(), Corredor.class);
		// Obtener datos de carrera
		Optional<Carrera> carrera = carreraDAO.findById(carreraCorredorDto.getCarreraNombre());

		// Hay que insertar el corredor, no hay cascade
		if (!corredorDAO.existsById(corredor.getDni()))
			corredorDAO.save(corredor);

		if (carrera.isPresent())
			if (carreraDAO.cuantosInscritos(carrera.get().getNombre()) <  carrera.get().getMaximo())
				if (carreraCorredorDAO.carrerasNoInscritasDelCorredor(corredor.getDni()).contains(carrera.get()))
				{
					dorsal = carreraDAO.cuantosInscritos(carrera.get().getNombre())+1;
					cc = CarreraCorredor.builder().
							carrera(carrera.get()).
							corredor(corredor).
							dorsal(dorsal).
							build();
					carreraCorredorDAO.save(cc);
				}
				else
					throw new RollBackException("corredor inscrito ya en la carrera " + carrera.get().getNombre());
			else
				throw new RollBackException("carrera " + carrera.get().getNombre() + " sin plazas");
		else
			throw new RollBackException("la carrera " + carrera.get().getNombre() + " no existe");

		System.out.println(corredor.getDni() + " ->"+ carrera.get().getNombre() +  "->" + dorsal);
		return dorsal;
	}

	@Override
	public boolean anotarTiempoCorredorCarrera(CarreraCorredorDto carreraCorredorDto) {
		Optional<CarreraCorredor> carreraCorredor;

		// Buscar corredorcarrera
		carreraCorredor = carreraCorredorDAO.
				findByCarreraAndCorredor(
						Carrera.builder().nombre(carreraCorredorDto.getCarreraNombre()).build(), 
						Corredor.builder().dni(carreraCorredorDto.getCorredorDni()).build());

		// Si el corredor y la carreran existen y el corredor está inscrito en la carrera		
		carreraCorredor.ifPresent(cc -> 
		{
			// Anotar tiempo
			cc.setTiempo(carreraCorredorDto.getTiempo()); 
			carreraCorredorDAO.save(cc);
		});	

		return carreraCorredor.isPresent(); // Devolver si se ha completado registro
	}

	@Override
	public List<CarreraCorredorDto> findAll() {
		return 	dtoConverter.
				mapAll((List<CarreraCorredor>) carreraCorredorDAO.findAll(), 
						CarreraCorredorDto.class);
	}

}
