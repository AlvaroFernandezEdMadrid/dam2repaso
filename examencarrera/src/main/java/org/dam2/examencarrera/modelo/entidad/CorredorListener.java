package org.dam2.examencarrera.modelo.entidad;

import jakarta.persistence.PrePersist;

public class CorredorListener {
	@PrePersist
	public void guardarCorredor (Corredor corredor)
	{
		System.out.println("guardando corredor ...");
		System.out.println(corredor);
	}

}
