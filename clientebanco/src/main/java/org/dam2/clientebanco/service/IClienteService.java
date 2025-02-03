package org.dam2.clientebanco.service;

import java.util.List;
import java.util.Optional;

import org.dam2.clientebanco.modelo.Cliente;



public interface IClienteService {


	public boolean insert (Cliente cliente);

	public boolean update (Cliente cliente);

	public boolean delete (String id);

	public List<Cliente> findAll ();

	public Optional <Cliente> findByNif (String nif);

	public int actualizarAval (String nif);



}
