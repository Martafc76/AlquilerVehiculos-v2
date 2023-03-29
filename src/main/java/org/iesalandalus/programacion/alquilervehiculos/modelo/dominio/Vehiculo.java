package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;

public abstract class Vehiculo {

	private static final String ER_MARCA = "([A-Z][a-z]+[- ]?([A-Z][a-z]+)*)|[A-Z]+";
	private static final String ER_MATRICULA = "\\d{4}([^\\WAEIOU\\-a-z]{3})";
	private String marca;
	private String modelo;
	private String matricula;
	
	protected Vehiculo(String marca, String modelo, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}

	public static Vehiculo getVehiculoConMatricula(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		return new Turismo("Seat","4x4",1000,matricula);
	}

	protected Vehiculo(Vehiculo vehiculo) {
		if(vehiculo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un vehículo nulo.");
		}
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		matricula = vehiculo.getMatricula();
		
		}
	
	public abstract int getFactorPrecio();
	
	public static Vehiculo copiar(Vehiculo vehiculo) {
		Vehiculo vehiculoCopia = null;
		if(vehiculo instanceof Turismo turismo) {
			vehiculoCopia = new Turismo(turismo);
		}
		
		if(vehiculo instanceof Furgoneta furgoneta) {
			vehiculoCopia = new Furgoneta(furgoneta);
		}
		
		if(vehiculo instanceof Autobus autobus ) {
			vehiculoCopia = new Autobus(autobus);
		}
	
		return vehiculoCopia;
	}
	
	public String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		
		if(marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if(!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
		
	}

	public String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		if(modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if(!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return  Objects.equals(matricula, other.matricula);
	}

}

//restringir decimales a dos