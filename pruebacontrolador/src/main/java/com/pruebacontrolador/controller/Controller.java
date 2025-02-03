package com.pruebacontrolador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebacontrolador.model.Material;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/prueba")
public class Controller {

	int nVisitas;

	public Controller() {
		nVisitas=0;
		System.out.println("Soy el constructor");

	}

	@GetMapping("/saluda")
	public ResponseEntity<String> saluda() throws InterruptedException{

		ResponseEntity<String> respuesta;
		nVisitas++;
		String mensaje=Thread.currentThread().getName();
		Random r=new Random();
		mensaje+=", visitas: "+nVisitas;
		Thread.currentThread().sleep(r.nextInt(1000)+1);
		respuesta=new ResponseEntity<String>(mensaje,HttpStatus.OK);

		return respuesta;

	}

	@GetMapping("/buscarmaterial")
	public ResponseEntity<Material> getMaterial(@RequestParam String id)
	{
		Material m;
		ResponseEntity<Material> respuesta;

		if (id.equals("00001")) {
			m=Material.builder()
					.referencia("00001")
					.nombre("The Crown")
					.director("Peter Morgan")
					.fechaEstreno(LocalDate.of(2021, 02, 02)).build();

			respuesta=new ResponseEntity<Material>(m, HttpStatus.OK);

		}else	
			respuesta= new ResponseEntity<Material>(HttpStatus.NOT_FOUND);

		return respuesta;

	}

	@PostMapping("/subirmaterial")
	public ResponseEntity<Material> postMaterial(@RequestBody Material m)
	{

		ResponseEntity<Material> respuesta;
		
		m.setNombre("Modificado");

		respuesta=new ResponseEntity<Material>(m,HttpStatus.OK);

		return respuesta;

	}



}
