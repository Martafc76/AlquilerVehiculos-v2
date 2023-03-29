package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaTexto extends Vista {

	public VistaTexto() {
		Accion.setVista(this);

	}

	@Override
	public void comenzar() {
		Accion accion = null;
		do {
			Consola.mostrarCabecera("Menú principal");
			Consola.mostrarMenuAcciones();
			accion = Consola.elegirOpcion();
			accion.ejecutar();
		} while (accion != Accion.SALIR);

	}

	public void terminar() {
		System.out.println("Que tengas un buen día!");
	}

	public void devolverAlquilerCliente() {
		Consola.mostrarCabecera("Devolver alquiler del cliente");
		try {
			getControlador().devolver(Consola.leerClienteDni(), Consola.leerFechaDevolucion());
			System.out.println("El alquiler ha sido devuelto correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void devolverAlquilerVehiculo() {
		Consola.mostrarCabecera("Devolver alquiler del vehiculo");
		try {
			getControlador().devolver(Consola.leerVehiculoMatricula(), Consola.leerFechaDevolucion());
			System.out.println("El alquiler ha sido devuelto correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		try {
			getControlador().insertar(Consola.leerCliente());
			System.out.println("Cliente insertado correctamente.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarVehiculo() {
		Consola.mostrarCabecera("Insertar vehículo");
		try {
			getControlador().insertar(Consola.leerVehiculo());
			System.out.println("Vehículo insertado correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		try {
			getControlador().insertar(Consola.leerAlquiler());
			System.out.println("Ha insertado un nuevo alquiler");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		Cliente cliente = null;
		try {
			cliente = getControlador().buscar(Consola.leerClienteDni());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (cliente == null) {
			System.out.println("El cliente no existe");
		} else {
			System.out.println(cliente);
		}

	}

	public void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo");
		Vehiculo turismo = null;
		try {
			turismo = getControlador().buscar(Consola.leerVehiculoMatricula());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (turismo == null) {
			System.out.println("El turismo no existe");
		} else {
			System.out.println(turismo);
		}

	}

	public void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
		Alquiler alquiler = null;
		try {
			alquiler = getControlador().buscar(Consola.leerAlquiler());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (alquiler == null) {
			System.out.println("El alquiler no existe");
		} else {
			System.out.println(alquiler);
		}

	}

	public void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		try {
			getControlador().modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.println("El cliente ha sido modificado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			getControlador().borrar(Consola.leerClienteDni());
			System.out.println("El cliente ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");
		try {
			getControlador().borrar(Consola.leerVehiculoMatricula());
			System.out.println("El turismo ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar Alquiler");
		try {
			getControlador().borrar(Consola.leerAlquiler());
			System.out.println("El alquiler ha sido borrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void listarClientes() {
		Consola.mostrarCabecera("Lista de clientes");
		List<Cliente> listaClientes = getControlador().getListaClientes();
		listaClientes.sort(Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni));
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}

	}

	public void listarVehiculos() {
		Consola.mostrarCabecera("Lista de vehiculos");
		List<Vehiculo> listaVehiculos = getControlador().getListaVehiculos();
		listaVehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getModelo).thenComparing(Vehiculo::getMatricula));
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo);
		}
	}

	public void listarAlquileres() {
		Consola.mostrarCabecera("Lista de alquileres");
		Comparator<Cliente> comparadorCliente = Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni);
		List<Alquiler> listaAlquileres = getControlador().getListaAlquileres();
		listaAlquileres.sort(Comparator.comparing(Alquiler::getFechaAlquiler).thenComparing(Alquiler::getCliente,comparadorCliente));
		for (Alquiler alquiler : listaAlquileres) {
			System.out.println(alquiler);
		}

	}

	public void listarAlquileresCliente() {
		Cliente cliente = Consola.leerClienteDni();
		Consola.mostrarCabecera("Lista de alquileres del cliente");
		Comparator<Cliente> comparadorCliente = Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni);
		List<Alquiler> listaAlquileres = getControlador().getListaAlquileres(cliente);
		listaAlquileres.sort(Comparator.comparing(Alquiler::getFechaAlquiler).thenComparing(Alquiler::getCliente,comparadorCliente));
		for (Alquiler alquiler : listaAlquileres) {
			System.out.println(alquiler);
		}
	}

	public void listarAlquileresVehiculo() {
		Vehiculo vehiculo = Consola.leerVehiculoMatricula();
		Consola.mostrarCabecera("Lista de alquileres del turismo");
		Comparator<Vehiculo> comparadorVehiculo = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getModelo).thenComparing(Vehiculo::getMatricula);
		List<Alquiler> listaAlquileres = getControlador().getListaAlquileres(vehiculo);
		listaAlquileres.sort(Comparator.comparing(Alquiler::getFechaAlquiler).thenComparing(Alquiler::getVehiculo, comparadorVehiculo));
		try {
			for (Alquiler alquileres : listaAlquileres) {
				System.out.println(alquileres);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void mostrarEstadisticasMensualesTipoVehiculo() {
		Map<TipoVehiculo, Integer> estadisticas = inicializarEstadisticas();
		try {
			LocalDate mes = Consola.leerMes();

			for (Alquiler alquiler : getControlador().getListaAlquileres()) {
				if (alquiler.getFechaAlquiler().getMonth().equals(mes.getMonth())
						&& alquiler.getFechaAlquiler().getYear() == mes.getYear()) {
					estadisticas.put(TipoVehiculo.get(alquiler.getVehiculo()),
							estadisticas.get(TipoVehiculo.get(alquiler.getVehiculo())) + 1);
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: El mes es incorrecto");
			estadisticas = null;
		}

		if (estadisticas != null) {
			System.out.println(estadisticas);
		}
			
	}

	private Map<TipoVehiculo, Integer> inicializarEstadisticas() {
		Map<TipoVehiculo, Integer> estadisticas = new EnumMap<>(TipoVehiculo.class);
		for (int i = 0; i < TipoVehiculo.values().length; i++) {
			estadisticas.put(TipoVehiculo.get(i), 0);
		}
		return estadisticas;
	}
}
