package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

public enum Accion {
	
	
	SALIR("Salir") {
		@Override
		public void ejecutar() {
		vista.terminar();
		}
	}, 
    INSERTAR_CLIENTE("Insertar cliente") {
		@Override
		public void ejecutar() {
			vista.insertarCliente();
		}
	}, 
    INSERTAR_VEHICULO("Insertar vehiculo") {
		@Override
		public void ejecutar() {
			vista.insertarVehiculo();
			
		}
	}, 
    INSERTAR_ALQUILER("Insertar alquiler") {
		@Override
		public void ejecutar() {
			vista.insertarAlquiler();
			
		}
	},
    BUSCAR_CLIENTE("Buscar cliente") {
		@Override
		public void ejecutar() {
			vista.buscarCliente();
			
		}
	},
    BUSCAR_VEHICULO("Buscar vehículo") {
		@Override
		public void ejecutar() {
			vista.buscarTurismo();
			
		}
	},
    BUSCAR_ALQUILER("Buscar alquiler") {
		@Override
		public void ejecutar() {
			vista.buscarAlquiler();
			
		}
	},
    MODIFICAR_CLIENTE("Modificar cliente") {
		@Override
		public void ejecutar() {
			vista.modificarCliente();
			
		}
	},
    DEVOLVER_ALQUILER_CLIENTE("Devolver alquiler del cliente") {
		@Override
		public void ejecutar() {
			vista.devolverAlquilerCliente();
			
		}
	},
    DEVOLVER_ALQUILER_VEHICULO("Devolver alquiler del vehiculo") {
		@Override
		public void ejecutar() {
			vista.devolverAlquilerVehiculo();
			
		}
	},
    BORRAR_CLIENTE("Borrar cliente") {
		@Override
		public void ejecutar() {
			vista.borrarCliente();
			
		}
	},
    BORRAR_VEHICULO("Borrar vehículo") {
		@Override
		public void ejecutar() {
			vista.borrarTurismo();
			
		}
	},
    BORRAR_ALQUILER("Borrar alquiler") {
		@Override
		public void ejecutar() {
			vista.borrarAlquiler();
			
		}
	},
    LISTAR_CLIENTES("Listar clientes") {
		@Override
		public void ejecutar() {
			vista.listarClientes();
			
		}
	},
    LISTAR_VEHICULOS("Listar vehiculos") {
		@Override
		public void ejecutar() {
			vista.listarVehiculos();
			
		}
	},
    LISTAR_ALQUILERES("Listar alquileres") {
		@Override
		public void ejecutar() {
			vista.listarAlquileres();
			
		}
	},
    LISTAR_ALQUILERES_CLIENTE("Listar alquileres de cliente") {
		@Override
		public void ejecutar() {
			vista.listarAlquileresCliente();
			
		}
	},
    LISTAR_ALQUILERES_VEHICULO("Listar alquileres de vehículo") {
		@Override
		public void ejecutar() {
			vista.listarAlquileresVehiculo();
			
		}
	},
    MOSTRAR_ESTADISTICAS_MENSUALES("Mostrar estadísticas mensuales"){

		@Override
		public void ejecutar() {
			vista.mostrarEstadisticasMensualesTipoVehiculo();
			
		}
		
	}
	;


	private String cadenaAMostrar;

	private static VistaTexto vista;
	
	private Accion(String nombre) {
		cadenaAMostrar = nombre;
	}
	
	static void setVista(VistaTexto vista) {
		Accion.vista = vista;
	}
	
	public abstract void ejecutar();
	
	private static boolean esOrdinalValido(int ordinal) {
		return ordinal >= 0 && ordinal < Accion.values().length;
	}
	
	public static Accion get(int ordinal) {
		if(!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("ERROR: El ordinal pasado no es válido");
		}
		
		return Accion.values()[ordinal];
	}
	
	
	@Override
	public String toString() {
		return String.format("%d) %s",ordinal(), cadenaAMostrar );
	}

}
