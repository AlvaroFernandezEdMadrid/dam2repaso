package org.vb.ejercicioRepaso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App 
{
	public static void main( String[] args )
	{
		ArrayList<Alumno> alumnos;
		
		alumnos=cargarAlumnos();
		
		alumnos.forEach(System.out::println);
	}

	public static ArrayList<Alumno> cargarAlumnos(){

		ArrayList<Alumno> alumnos=new ArrayList();

		Alumno alumno;
		String linea;

		// Leer alumnos del fichero
		try (BufferedReader buffer = new BufferedReader(new FileReader ("alumnos.csv")))
		{

			while (buffer.ready()&&alumnos.size()<10)
			{
				linea = buffer.readLine();
				alumno = new Alumno ();
				alumno.fromCsv(linea);
				alumnos.add(alumno);
			}


		}  catch (IOException e) {
			System.err.println("\nError leyendo fichero...");
		}

		return alumnos;
	}
}

