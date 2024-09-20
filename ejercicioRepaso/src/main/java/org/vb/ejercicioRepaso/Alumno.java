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

	private final String SEPARADOR=";";
	@EqualsAndHashCode.Include
	@NonNull
	private String nia;
	private String nombre;
	private LocalDate fechaNac;
	private float nota;
	private boolean repetidor;
	private String curso;

	public void fromCsv(String linea) {

		String valores[] = linea.split(SEPARADOR);

		if (valores.length > 0)
		{
			try
			{
				nia = valores[0];
				nombre = valores[1];
				setFechaNac(LocalDate.parse(valores[2]));
				setNota(Float.valueOf(valores[3]));
				setRepetidor(Boolean.valueOf(valores[4]));
				setCurso(valores[5]);
			}
			catch (IndexOutOfBoundsException e)
			{
				switch (valores.length)
				{
				case 1:
					nombre = "";
				case 2:
					fechaNac= LocalDate.now().minusYears(18);
				case 3:
					nota = 1;
				case 4:
					repetidor=false;
				case 5:
					curso="";
				}
			}
			catch (DateTimeParseException e)
			{
				fechaNac = LocalDate.now().minusYears(18);
			}
			catch (NumberFormatException e)
			{
				nota = 1;
			}
			catch (IllegalArgumentException e)
			{
				if (e.getMessage().equals ("nota no permitida"))
					nota = 1;
				else if (e.getLocalizedMessage().contains("alumno"))
					fechaNac = LocalDate.now().minusYears(18);

			}
		}
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
