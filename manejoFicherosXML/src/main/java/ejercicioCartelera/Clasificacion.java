package ejercicioCartelera;

import java.util.ArrayList;
import java.util.List;

public enum Clasificacion {
	/*Todo publico*/TP,
	/*Adolescentes y niños*/A,
	/*Con supervisión padres*/BO,
	/*Contenido para adolescentes*/R,
	/*Contenido para adultos*/D;
	
	public List<String> asList(){
		List<String> valores=new ArrayList<String>();
		
		for (Clasificacion c : Clasificacion.values()) {
			valores.add(c.toString());
		}
		
		return valores;
	}
}
