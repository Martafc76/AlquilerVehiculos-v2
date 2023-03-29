package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public interface IClientes {

	// me devuelve una nueva arrayList con los mismo elementos
	List<Cliente> get();

	//devuelve la cantidad de elementos que contiene la lista
	int getCantidad();

	void insertar(Cliente cliente) throws OperationNotSupportedException;

	Cliente buscar(Cliente cliente);

	void borrar(Cliente cliente) throws OperationNotSupportedException;

	void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException;

}