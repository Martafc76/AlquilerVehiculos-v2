package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final String PATRON_MES = "MM/yyyy";

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		StringBuilder delineado = new StringBuilder();
		for (int i = 0; i < mensaje.length(); i++) {
			delineado.append("-");
		}

		System.out.println(delineado);
	}

	public static void mostrarMenuAcciones() {
		System.out.println("Eliga una de las siguientes opciones: ");
		for (Accion opcion : Accion.values()) {
			System.out.println(opcion);
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.printf("Introduce %s:", mensaje);
		return Entrada.cadena();
	}

	private static int leerEntero(String mensaje) {
		System.out.printf("Introduce %s: ", mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje, String patron) {
		LocalDate fecha = null;
		System.out.printf("Introduce %s (%s): ", mensaje, patron);	
		
		
		try {
			if(patron.equals(PATRON_FECHA)) {
			fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		} 
		
			if(patron.equals(PATRON_MES)) {
				fecha = LocalDate.parse("01/"+Entrada.cadena(), FORMATO_FECHA);
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR: La fecha introducida no es válida.");
		}

		return fecha;
	}

	public static Accion elegirOpcion() {

		Accion opcion = null;
		do {

			int indice = leerEntero("la opción deseada ");
			try {
				opcion = Accion.get(indice);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opcion == null);

		return opcion;
	}

	public static Cliente leerCliente() {
		Cliente cliente = null;

		cliente = new Cliente(leerNombre(), leerCadena("el dni"), leerTelefono());

		return cliente;

	}

	public static Cliente leerClienteDni() {
		Cliente cliente = null;
		cliente = Cliente.getClienteConDni(leerCadena("el dni del cliente"));

		return cliente;

	}

	public static String leerNombre() {
		return leerCadena("el nombre");
	}

	public static String leerTelefono() {
		return leerCadena("el número de telefono");

	}

	public static Vehiculo leerVehiculo() {
		Consola.mostrarMenuTipoVehiculos();
		return leerVehiculo(elegirTipoVehiculo());

	}

	private static void mostrarMenuTipoVehiculos() {
		Consola.mostrarCabecera("Tipos de vehiculos");
		for (TipoVehiculo tipoVehiculo : TipoVehiculo.values()) {
			System.out.println(tipoVehiculo);
		}
	}

	private static TipoVehiculo elegirTipoVehiculo() {
		return TipoVehiculo.get(Consola.leerEntero("el tipo de vehiculo"));
	}

	private static Vehiculo leerVehiculo(TipoVehiculo tipoVehiculo) {
		Vehiculo vehiculo = null;
		String marca = Consola.leerCadena("la marca");
		String modelo = Consola.leerCadena("el modelo");
		String matricula = Consola.leerCadena("la matricula");
		if (tipoVehiculo.equals(TipoVehiculo.TURISMO)) {
			vehiculo = new Turismo(marca, modelo, Consola.leerEntero("la cilindrada"), matricula);
		}

		if (tipoVehiculo.equals(TipoVehiculo.FURGONETA)) {
			vehiculo = new Furgoneta(marca, modelo, Consola.leerEntero("el PMA"), Consola.leerEntero("las plazas"),
					matricula);
		}

		if (tipoVehiculo.equals(TipoVehiculo.AUTOBUS)) {
			vehiculo = new Autobus(marca, modelo, Consola.leerEntero("las plazas"), matricula);
		}

		return vehiculo;
	}

	public static Vehiculo leerVehiculoMatricula() {
		return Vehiculo.getVehiculoConMatricula(leerCadena("la matricula del vehículo"));

	}

//cliente,turismo,fechaAlquiler
	public static Alquiler leerAlquiler() {
		Alquiler alquiler = null;

		alquiler = new Alquiler(leerClienteDni(), leerVehiculoMatricula(),
				leerFecha("la fecha de alquiler", PATRON_FECHA));

		return alquiler;

	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("la fecha de devolución", PATRON_FECHA);

	}

	public static LocalDate leerMes() {
		return Consola.leerFecha("el mes", PATRON_MES);

	}

}
