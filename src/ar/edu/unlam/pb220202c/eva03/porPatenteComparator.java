package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class porPatenteComparator implements Comparator<Vehiculo> {
	
	@Override
	public int compare(Vehiculo vehiculo1, Vehiculo vehiculo2) {
		return vehiculo1.getPatente().compareTo(vehiculo1.getPatente());
	}

}
