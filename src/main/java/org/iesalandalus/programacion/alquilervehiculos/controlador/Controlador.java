package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	Modelo modelo;
	Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		if(modelo == null) {
			throw new NullPointerException("ERROR: Modelo es nulo");
		}
		
		if(vista == null) {
			throw new NullPointerException("ERROR: Vista es nula");
		}
		this.modelo = modelo;
		this.vista = vista;
		vista.setControlador(this);
	}
	
	
	public void comenzar() {
		modelo.comenzar();
		vista.comenzar();
	}

	public void terminar() {
		vista.terminar();
	    modelo.terminar();
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
	    modelo.insertar(cliente);
	}

	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
	   modelo.insertar(vehiculo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(alquiler);
	  
	}

	public Cliente buscar(Cliente cliente) {
	  return modelo.buscar(cliente);
	}

	public Vehiculo buscar(Vehiculo turismo) {
	    return modelo.buscar(turismo);
	}

	public Alquiler buscar(Alquiler alquiler) {
	    return buscar(alquiler);
	    
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
	    modelo.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(vehiculo, fechaDevolucion);
	}
	
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modelo.devolver(cliente, fechaDevolucion);
	}

	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(cliente);
	}
	
	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.borrar(alquiler);
	}
	
	//
	public List<Cliente> getListaClientes(){
		return modelo.getListaClientes();
		}
	
	//
	public List<Vehiculo> getListaVehiculos(){
		return modelo.getListaVehiculos();
		}
	
	public List<Alquiler> getListaAlquileres(){
		return modelo.getListaAlquileres();
		}
		
	public List<Alquiler> getListaAlquileres(Cliente cliente){
		return modelo.getListaAlquileres(cliente);
	}
	
	public List<Alquiler> getListaAlquileres(Vehiculo turismo){
		return modelo.getListaAlquileres(turismo);
	}
}
