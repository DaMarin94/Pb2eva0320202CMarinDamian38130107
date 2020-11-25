package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista delSur = new Autopista ("Autopista del Sur");
		Vehiculo auto1 = new Automovil("ATR123");
		
		delSur.registrarTelepase(123, auto1);
		
		assertEquals((Integer)1, delSur.getCantidadDeVehiculosRegistradosEnTelepase());
	}

	@Test (expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException{
		Autopista delSur = new Autopista ("Autopista del Sur");
		Vehiculo auto1 = new Automovil("ATR123");
		delSur.registrarTelepase(123, auto1);
		delSur.ingresarAutopista(124);
		delSur.salirAutpista(auto1);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		
		Autopista delSur = new Autopista ("Autopista del Sur");
		Vehiculo auto1 = new Automovil("BTR123");
		Vehiculo auto2 = new Automovil("ATR123");
		Vehiculo camion1 = new Automovil("CTR123");
		
		auto1.incrmentarVelocidad(150);
		auto2.incrmentarVelocidad(150);
		camion1.incrmentarVelocidad(100);
		
		delSur.agregarVehiculosConInfreccion();
		
		assertEquals(delSur.getVehiculosConInfreccion().first(), delSur.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first());
	}
	
	@Test
	public void queNoExistanVehiculosDeMismoNumeroTelepase() {
		Autopista delSur = new Autopista ("Autopista del Sur");
		Vehiculo auto1 = new Automovil("ATR123");
		Vehiculo auto2 = new Automovil("ATR321");
		Vehiculo camion1 = new Automovil("ATR156");
		
		delSur.registrarTelepase(123, auto1);
		delSur.registrarTelepase(124, auto2);
		delSur.registrarTelepase(123, camion1);
		
		try {
			delSur.ingresarAutopista(123);
			delSur.ingresarAutopista(124);
			delSur.ingresarAutopista(123);
		} catch (VehiculoNotFounException e) {
			e.printStackTrace();
		}
		
		assertEquals((Integer)2, delSur.getCantidadDeVehiculosRegistradosEnTelepase());
		
	}
	
	@Test (expected = VehiculoNotFounException.class)
	public void queAlEntrarALaAutopistaNoEstaRegistradoEnTelepaseException() throws VehiculoNotFounException{
		Autopista delSur = new Autopista ("Autopista del Sur");
		Vehiculo auto1 = new Automovil("ATR123");
		delSur.registrarTelepase(123, auto1);
		
		delSur.ingresarAutopista(124);
	}
	
}
