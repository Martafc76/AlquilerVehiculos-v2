package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes {
	
	private List<Cliente> coleccionClientes;
	
	public Clientes(){
		//array inicializada que está vacía
		coleccionClientes = new ArrayList<>();
	}
	// me devuelve una nueva arrayList con los mismo elementos
	@Override
	public List<Cliente> get() {
		return new ArrayList<>(coleccionClientes);
	}
	
	//devuelve la cantidad de elementos que contiene la lista
	@Override
	public int getCantidad() {
		return coleccionClientes.size();
	}
	
	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if(cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if(coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		coleccionClientes.add(cliente);
	}
	
	@Override
	public Cliente buscar(Cliente cliente) {
		if(cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		
		int indice = coleccionClientes.indexOf(cliente);

		return indice == -1 ? null : coleccionClientes.get(indice);
	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if(cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if(coleccionClientes.contains(cliente)) {
			coleccionClientes.remove(cliente);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
	}
	
	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
		if(cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
			}
		
		if(!coleccionClientes.contains(cliente)){
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		if(nombre != null && !nombre.isBlank()) {
			coleccionClientes.get(coleccionClientes.indexOf(cliente)).setNombre(nombre);
			
		}
		
		if(telefono != null && !telefono.isBlank()) {
			coleccionClientes.get(coleccionClientes.indexOf(cliente)).setTelefono(telefono);
			
		}
		
	
	}

}
