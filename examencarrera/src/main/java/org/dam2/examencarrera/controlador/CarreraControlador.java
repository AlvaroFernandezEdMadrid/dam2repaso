package org.dam2.examencarrera.controlador;

import java.util.List;
import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.servicio.ICarreraCorredorServicio;
import org.dam2.examencarrera.servicio.ICarreraServicio;
import org.dam2.examencarrera.servicio.ICorredorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carreras/carrera")
public class CarreraControlador {

	@Autowired ICorredorServicio corredorServicio;
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICarreraCorredorServicio carreraCorredorServicio;

	@GetMapping ("/consultar")
	public ResponseEntity<List<CarreraDto>> obtenerTodasCorrerras ()
	{
		return ResponseEntity.ok(carreraServicio.findAll());
	}


	@GetMapping ("/consultar/{nombre}")
	public ResponseEntity<CarreraDto> obtenerCarrera (@PathVariable String nombre)
	{		

		return ResponseEntity.of(carreraServicio.findByNombre(nombre));
	}

	@GetMapping ("/consultarcorredores/{nombre}")
	public ResponseEntity<List<CorredorDto>> obtenerCorredores (@PathVariable String nombre)
	{
		return ResponseEntity.
				of(carreraServicio.findByNombre(nombre).
						map(c -> carreraServicio.obtenerCorredores (c.getNombre())));
	}

	@PostMapping("/inscribir")
	public ResponseEntity<Integer> inscribirCorredor (@RequestBody CarreraConCorredorCompletoDto carreraCorredorDto)

	{
		HttpStatus status = HttpStatus.BAD_REQUEST;
		int dorsal = 0;

		try 
		{
			dorsal = carreraCorredorServicio.insertarCorredorCarrera(carreraCorredorDto);
			if (dorsal > 0)
				status = HttpStatus.CREATED;
		}
		catch (RollBackException ex)
		{
			System.out.println(ex.getMensaje());
		}		
		return new ResponseEntity<>(dorsal,status);
	}

	@PutMapping("/anotartiempo")
	public ResponseEntity<String> anotarTiempo (@RequestBody CarreraCorredorDto carreraCorredorDto)
	{
		ResponseEntity<String> respuesta;		

		respuesta = 
				carreraCorredorServicio.anotarTiempoCorredorCarrera(carreraCorredorDto)?
						ResponseEntity.accepted().
						body("tiempo anotado al corredor " + carreraCorredorDto.getCorredorDni()):
							ResponseEntity.badRequest().build();
		return respuesta;
	}

	@GetMapping ("/consultarcarrerasdisponibles/{dni}")
	public ResponseEntity<List<CarreraDto>> carrerasDisponiblesPorCorredor (@PathVariable String dni)
	{		
		return ResponseEntity.ok(carreraServicio.carrerasDisponiblesPorCorredor(dni));
	}

	@GetMapping ("/consultarmasantigua")
	public ResponseEntity<List<CorredorDto>> obtenerCorredoresMasAntigua ()
	{	
		return ResponseEntity.ok(carreraServicio.clasificacionCarreraMasAntigua());
	}
}
