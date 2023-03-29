package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public enum TipoVehiculo {

	TURISMO("Turismo"),
	AUTOBUS("Autobus"),
	FURGONETA("Furgoneta");
	
	private String nombre;
	

	
	private TipoVehiculo(String nombre) {
		this.nombre = nombre;
	}
	
	private static boolean esOrdinalValido(int ordinal) {
		return ordinal >= 0 && ordinal < TipoVehiculo.values().length;
	}
	
	public static TipoVehiculo get(int ordinal) {
		if(!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("ERROR: El ordinal pasado no es válido");
		}
		
		return TipoVehiculo.values()[ordinal];
	}
	
	public static TipoVehiculo get(Vehiculo vehiculo) {
		TipoVehiculo tipoVehiculo = null;
		if(vehiculo instanceof Turismo ) {
			tipoVehiculo = TURISMO;
		}
		
		if(vehiculo instanceof Autobus ) {
			tipoVehiculo = AUTOBUS;
		}
		
		if(vehiculo instanceof Furgoneta ) {
			tipoVehiculo = FURGONETA;
		}
		return tipoVehiculo;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %s",ordinal(), nombre );
	}
}
