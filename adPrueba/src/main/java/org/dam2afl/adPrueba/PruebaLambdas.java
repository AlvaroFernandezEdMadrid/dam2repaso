package org.dam2afl.adPrueba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PruebaLambdas {

	public static void main(String[] args) {
		List<Alumno> alumnos=new ArrayList<Alumno>();
		
		Consumer<Alumno> escribidor;
		Predicate<Alumno> mayorDeEdad;
		Supplier<Alumno> productor;
		

		Alumno a,b,c,d;

		a=Alumno.builder().
				dni("001").
				nombre("A1").
				edad(20).
				build();

		b=Alumno.builder().
				dni("002").
				nombre("A1").
				build();
		
		alumnos.add(a);
		alumnos.add(b);
		
		escribidor=al->System.out.println(al); //System.out::println 
		
		alumnos.forEach(escribidor);
		
		System.out.println("----------------");
		
		mayorDeEdad= al -> al.getEdad()>=18; //Quita los menores de edad
		
		alumnos.removeIf(mayorDeEdad.negate());
		
		alumnos.forEach(escribidor);
		
		System.out.println("----------------");
		
		productor= ()-> new Alumno(Integer.toString(Libreria.generarAleatorio(1, 1000)));
		
		alumnos.add(productor.get());
		
		alumnos.forEach(escribidor);
		
		System.out.println("----------------");
		
		
	}

}
