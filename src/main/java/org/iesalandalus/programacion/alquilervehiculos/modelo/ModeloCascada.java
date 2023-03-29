package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;

public class ModeloCascada extends Modelo {

	public ModeloCascada(IFuenteDatos fuenteDatos) {
		setFuenteDatos(fuenteDatos);
	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		getClientes().insertar(new Cliente(cliente));
	}

	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		getVehiculos().insertar(vehiculo);
	}

	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente cliente = getClientes().buscar(alquiler.getCliente());

		if (cliente == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}

		Vehiculo vehiculo = getVehiculos().buscar(alquiler.getVehiculo());

		if (vehiculo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el vehiculo del alquiler.");
		}

		getAlquileres().insertar(new Alquiler(cliente, vehiculo, alquiler.getFechaAlquiler()));

	}

	@Override
	public Cliente buscar(Cliente cliente) {
		return new Cliente(getClientes().buscar(cliente));
	}

	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
		return (getVehiculos().buscar(vehiculo));
	}

	@Override
	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(getAlquileres().buscar(alquiler));

	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		getClientes().modificar(cliente, nombre, telefono);
	}

	@Override
	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		getAlquileres().devolver(vehiculo, fechaDevolucion);
	}

	@Override
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		getAlquileres().devolver(cliente, fechaDevolucion);
	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : getAlquileres().get(cliente)) {
			getAlquileres().borrar(alquiler);
		}
		getClientes().borrar(cliente);
	}

	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		for (Alquiler alquiler : getAlquileres().get(vehiculo)) {
			getAlquileres().borrar(alquiler);
		}
		getVehiculos().borrar(vehiculo);
	}

	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		getAlquileres().borrar(alquiler);
	}

	@Override
	public List<Cliente> getListaClientes() {
		List<Cliente> clienteDevuelve = new ArrayList<>();
		for (Cliente cliente : getClientes().get()) {
			clienteDevuelve.add(new Cliente(cliente));

		}
		return clienteDevuelve;
	}

	@Override
	public List<Vehiculo> getListaVehiculos() {
		List<Vehiculo> vehiculoDevuelve = new ArrayList<>();
		for (Vehiculo vehiculo : getVehiculos().get()) {
			vehiculoDevuelve.add(Vehiculo.copiar(vehiculo));
		}
		return vehiculoDevuelve;
	}

	@Override
	public List<Alquiler> getListaAlquileres() {
		List<Alquiler> alquileresADevolver = new ArrayList<>();
		for (Alquiler alquiler : getAlquileres().get()) {
			alquileresADevolver.add(new Alquiler(alquiler));

		}
		return alquileresADevolver;
	}

	@Override
	public List<Alquiler> getListaAlquileres(Cliente cliente) {
		List<Alquiler> alquileresADevolver = new ArrayList<>();
		for (Alquiler alquiler : getAlquileres().get(cliente)) {
			alquileresADevolver.add(new Alquiler(alquiler));
		}
		return alquileresADevolver;
	}

	@Override
	public List<Alquiler> getListaAlquileres(Vehiculo vehiculo) {
		List<Alquiler> alquileresADevolver = new ArrayList<>();
		for (Alquiler alquiler : getAlquileres().get(vehiculo)) {
			alquileresADevolver.add(new Alquiler(alquiler));

		}
		return alquileresADevolver;
	}

}
