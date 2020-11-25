package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista{
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private String nombre;
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private TreeSet <Vehiculo> vechiculosEnInfraccion;
	
	public Autopista (String nombre) {
		this.setNombre(nombre);
		this.telepase = new HashMap <> ();
		this.vehiculosEnCirculacion = new HashSet <> ();
		this.vechiculosEnInfraccion = new TreeSet <> ();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		if(!telepase.containsKey(numeroTelpase)) {
			telepase.put(numeroTelpase, vehiculo);
			return true;
		}
		return false;
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		if(!telepase.containsKey(numeroTelepase)) {
			throw new VehiculoNotFounException("No se encuentra registrado en el telepase");
		}else {
			return vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		}

	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		if(!vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFounException("No esta en circulacion");
		}
		
	}
	
	public void agregarVehiculosConInfreccion() {
		for(Vehiculo vehiculoTemp : vehiculosEnCirculacion) {
			if(vehiculoTemp.enInfraccion())
				vechiculosEnInfraccion.add(vehiculoTemp);
		}
	}
	
	public TreeSet<Vehiculo> getVehiculosConInfreccion(){
		return vechiculosEnInfraccion;
    }
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		vechiculosEnInfraccion.comparator();
		return vechiculosEnInfraccion;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		return vehiculosEnCirculacion.size();
	}
	
	public Integer getCantidadDeVehiculosRegistradosEnTelepase() {
		return telepase.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
