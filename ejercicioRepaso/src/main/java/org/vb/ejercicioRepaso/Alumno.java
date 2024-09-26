package org.vb.ejercicioRepaso;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true) 
@Builder
public class Alumno implements Comparable<Alumno>{

	private final static String SEPARADOR=";";
	@EqualsAndHashCode.Include
	@NonNull
	private String nia;
	private String nombre;
	private LocalDate fechaNac;
	private float nota;
	private boolean repetidor;
	private String curso;

	public static Alumno fromCsv(String linea) {

		String valores[] = linea.split(SEPARADOR);
		Alumno a;
		
		a=new Alumno();

		if (valores.length > 0)
		{
			try
			{
				a.setNia(valores[0]);
				a.setNombre(valores[1]);
				a.setFechaNac(LocalDate.parse(valores[2]));
				a.setNota(Float.valueOf(valores[3]));
				a.setRepetidor(Boolean.valueOf(valores[4]));
				a.setCurso(valores[5]);
				
			}
			catch (IndexOutOfBoundsException e)
			{
				switch (valores.length)
				{
				case 1:
					a.setNombre("");
				case 2:
					a.setFechaNac(LocalDate.now().minusYears(18));
				case 3:
					a.setNota(0);
				case 4:
					a.setRepetidor(false);
				case 5:
					a.setCurso("");
				}
			}
			catch (DateTimeParseException e)
			{
				a.setFechaNac(LocalDate.now().minusYears(18));;
			}
			catch (NumberFormatException e)
			{
				a.setNota(0);
			}
			catch (IllegalArgumentException e)
			{
				if (e.getMessage().equals ("nota no permitida"))
					a.setNota(0);
				else if (e.getLocalizedMessage().contains("alumno"))
					a.setFechaNac(LocalDate.now().minusYears(18));

			}
		}
		return a;
	}
	
	public String toString() {
		return "Alumno [nia= " + nia 
				+ ", nombre= " + nombre 
				+ ", fechaNacimiento= " + fechaNac 
				+ ", nota= " + nota
				+ ", repetidor= " + repetidor
				+ ", curso= " + curso
				+"]";
	}

	@Override
	public int compareTo(Alumno o) {
		return nia.compareTo(o.nia);
	}

}
