package ejercicioCartelera;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cartelera {
	
	//Ejercicio -> Mostrar actores que han hechos peliculas posteriormente al 2003
	private List<Pelicula> peliculas;
	
}
