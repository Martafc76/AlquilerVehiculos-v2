package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {

	private Controlador controlador;

	public abstract void terminar();

	public abstract void comenzar();
	
	protected Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador es nulo");
		}
		this.controlador = controlador;
	
	}

}