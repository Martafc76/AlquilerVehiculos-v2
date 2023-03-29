package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Cliente {
	private String nombre;
	private String dni;
	private String telefono;
	private static final String ER_NOMBRE = "[A-ZÁÉÍÓÚ][a-záéíóú]+([ ][A-Z][a-záéíóú]+)*";
	private static final String ER_DNI = "\\d{8}[^\\WÑOUI\\-a-z]";
	private static final String ER_TELEFONO = "[69]\\d{8}";

	public Cliente(String nombre, String dni ,String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public Cliente(Cliente cliente) {
		if(cliente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		telefono = cliente.getTelefono();

	}

	private boolean comprobarLetraDni(String dni) {
		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		char letradni = dni.charAt(dni.length() -1);
		int numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
        int resto = numDni%23;
        return (letraDni[resto] == letradni);
		}


	public static Cliente getClienteConDni(String dni) {
		return new Cliente("Marta",dni,"666666666");

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		if(!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if(dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if(!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if(!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
			
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if(telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		if(!telefono.matches(ER_TELEFONO)){
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return(String.format("%s - %s (%s)", nombre, dni, telefono));
	}
	
	
}