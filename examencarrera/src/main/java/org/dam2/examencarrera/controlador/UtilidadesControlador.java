package org.dam2.examencarrera.controlador;

import java.time.LocalDate;

import org.dam2.examencarrera.configuracion.DtoConverter;
import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
import org.dam2.examencarrera.modelo.dto.CarreraConPCDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.dto.PuntoControlDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.modelo.entidad.PuntoControl;
import org.dam2.examencarrera.repositorio.CarreraRepositorio;
import org.dam2.examencarrera.servicio.ICarreraCorredorServicio;
import org.dam2.examencarrera.servicio.ICarreraServicio;
import org.dam2.examencarrera.servicio.ICorredorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carreras/utilidades")
public class UtilidadesControlador {

	@Autowired ICorredorServicio corredorServicio;
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICarreraCorredorServicio carreraCorredorServicio;
	@Autowired DtoConverter dtoConverter;

	private static boolean datosCargados = false;

	@GetMapping ("/cargardatos")
	public ResponseEntity<String> cargarDatos ()
	{
		ResponseEntity<String> response;
		CorredorDto c1,c2;
		CarreraConPCDto ca1, ca2;
		CarreraConCorredorCompletoDto ccc1, ccc2,ccc3,ccc4;
		String mensaje = "datos cargados correctamente";


		if (!datosCargados)
		{
			datosCargados = true;

			c1 = CorredorDto.builder().dni("001").nombre("c1").sexo(true).build();
			c2 = CorredorDto.builder().dni("002").nombre("c2").sexo(false).build();

			// No hace falta lo inserta al inscribirse la primera vez
			// Lo hace el servicio de CarreraCorredor al insertar
			//corredorServicio.insertar(c1);
			//corredorServicio.insertar(c2);

			ca1 = CarreraConPCDto.builder().
					nombre("ca1").
					maximo(10).
					fecha(LocalDate.now().minusYears(1)).
					pc(PuntoControlDto.builder().juez("j1").pk(1f).build()).
					pc(PuntoControlDto.builder().juez("j2").pk(5f).build()).
					build();

			ca2 = CarreraConPCDto.builder().
					nombre("ca2").
					maximo(20).
					fecha(LocalDate.now()).
					pc(PuntoControlDto.builder().juez("j3").pk(2f).build()).
					pc(PuntoControlDto.builder().juez("j4").pk(15f).build()).
					build();

			carreraServicio.insertar(ca1);
			carreraServicio.insertar(ca2);

			System.out.println("listado de carreras creadas");
			carreraServicio.findAll().forEach(System.out::println);

			ccc1 = CarreraConCorredorCompletoDto.builder().
					corredor(c1).
					carreraNombre(ca1.getNombre()).
					build();
			ccc2 = CarreraConCorredorCompletoDto.builder().
					corredor(c1).
					carreraNombre(ca2.getNombre()).
					build();
			ccc3 = CarreraConCorredorCompletoDto.builder().
					corredor(c2).
					carreraNombre(ca1.getNombre()).
					build();
			ccc4 = CarreraConCorredorCompletoDto.builder().
					corredor(c2).
					carreraNombre(ca2.getNombre()).
					build();

			try { 
				carreraCorredorServicio.insertarCorredorCarrera(ccc1);
				carreraCorredorServicio.insertarCorredorCarrera(ccc2);
				carreraCorredorServicio.insertarCorredorCarrera(ccc3);
				carreraCorredorServicio.insertarCorredorCarrera(ccc4);
			}
			catch (RollBackException ex)
			{
				System.out.println(ex.getMensaje());
				mensaje = ex.getMensaje();
			}

			System.out.println("listado de corredores creados");
			corredorServicio.findAll().forEach(System.out::println);

			System.out.println("listado de corredores inscritos en carreras");
			carreraCorredorServicio.findAll().forEach(System.out::println);

			response = new ResponseEntity<>(mensaje,HttpStatus.OK);
		}
		else
			response = new ResponseEntity<>("datos cargados anteriormente",HttpStatus.OK);
		return response;

	}


}
