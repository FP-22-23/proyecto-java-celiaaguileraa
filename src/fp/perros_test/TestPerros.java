package fp.perros_test;

import java.util.List;
import java.util.Map;

import fp.perros.FactoriaPerros;
import fp.perros.Perro;
import fp.perros.Perros;
import fp.perros.Tamaño;

public class TestPerros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Perros p = FactoriaPerros.leerPerros("data/Dogs.csv");
		 System.out.println("Perros: " + p);
		 
		 //test existe
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de existe:");
		 testExisteIdPerro(p, 937);
		 
		 //test media
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de getMediaPesoSegunTamaño:");
		 testGetMediaPesoSegunTamaño(p, Tamaño.LARGE);
		 
		 //Test filtro
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de filtraPorPerrosCastrados:");
		 testFiltraPorPerrosCastrados(p);
		 
		 //Test agrupacion
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de getListaPorPeso:");
		 testGetListaPorPeso(p);
		 
		 //Test contador
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de getNumeroPerrosPorRaza():");
		 testGetNumeroPerrosPorRaza(p);
		 
		 
		// Test Stream existe
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de existeStream:");
		 testExisteStream(p, 154);
		 
		 //Test Stream Media de peso de los perros pequeños
		 System.out.println("-----------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de getMediaPesoSegunTamañoStream:");
		 testGetMediaPesoSegunTamañoStream(p, Tamaño.LARGE);
		 
		 //Test Stream filtrado de perros vacunados
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de filtraPorPerrosCastradosStream:");
		 testFiltraPorPerrosCastradosStream(p);
		 
		 //Test Stream mayor peso de perros pequeños
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetPerroPequeñoMaxPesoStream:");
		 testGetPerroPequeñoMaxPesoStream(p,Tamaño.SMALL);
		 
		 //Test Stream perros machos filtrado segun si estan castrados y ordenados por fecha de encuentro
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetPerrosMachosCastradosOrdenadoFechaEncontrados:");
		 testGetPerrosMachosCastradosOrdenadoFechaEncontrados(p);
		 
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetNumeroPerrosPorRazaStream:");
		 testGetNumeroPerrosPorRazaStream(p);


		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetPesoPorTamaño:");
		 testGetPesoPorTamaño(p);
		 
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetMaxPesoPorTamaño:");
		 testGetMaxPesoPorTamaño(p);
		 
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de GetPerrosMenorPesoPorSexo:");
		 testGetPerrosMenorPesoPorSexo(p, 5);
		 
		 System.out.println("------------------------------------------------------------------------------------------------------------");
		 System.out.println("Test de MenorPesoPorSexo:  ");
		 testMenorPesoPorSexo(p);
		 
		 }
	
	
	
	
		 
		 
	private static void testExisteIdPerro(Perros p, Integer id) {
		Boolean res=p.existeIdPerro(id);
		System.out.println("Existe?");
		System.out.println(res);
		}

	private static void testGetListaPorPeso(Perros p) {
		Map<Double, List<Perro>>res=p.getListaPorPeso();
		System.out.println("La lista según el peso es:");
		System.out.println(res);
		
	}

	private static void testFiltraPorPerrosCastrados(Perros p) {
		List<Integer>res=p.filtraPorPerrosCastrados();
		System.out.println("El id de los perros castrados son: ");
		System.out.println(res);
	}
		
		
	

	private static void testGetMediaPesoSegunTamaño(Perros p, Tamaño t) {
		Double Media=p.getMediaPesoSegunTamaño(t);
		System.out.println("La media del peso segun tamaño es: ");
		System.out.println(Media);
		
	}
	
	private static void testGetNumeroPerrosPorRaza(Perros p) {
		Map<List<String>, Integer> res=p.getNumeroPerrosPorRaza();
		System.out.println("El numero de perros segun raza es: ");
		System.out.println(res);
		
	}
	
	
	private static void testExisteStream(Perros p, Integer id) {
		System.out.println("¿Existe algun perro con el id "+id+"?");
		System.out.println(p.existeStream(id));
	}
	
	private static void testGetMediaPesoSegunTamañoStream(Perros p, Tamaño t) {
		System.out.println("La media del peso segun tamaño es(calculado con stream): ");
		System.out.println(p.getMediaPesoSegunTamañoStream(t));
	}
	private static void testFiltraPorPerrosCastradosStream(Perros p) {
		System.out.println("El id de los perros castrados son: ");
		System.out.println(p.filtraPorPerrosCastradosStream());
	}
	
	private static void testGetPerroPequeñoMaxPesoStream(Perros p,Tamaño t) {
		System.out.println("La maximo peso entro los perros pequeños es: ");
		System.out.println(p.getPerroPequeñoMaxPesoStream(t));
	}
	
	private static void testGetPerrosMachosCastradosOrdenadoFechaEncontrados(Perros p) {
		System.out.println("Los perros machos castrados ordenados segun fecha son: ");
		System.out.println(p.getPerrosMachosCastradosOrdenadoFechaEncontrados());
	}
	
	private static void testGetNumeroPerrosPorRazaStream(Perros p) {
		System.out.println("Numero de perros segun la raza: ");
		System.out.println(p.getNumeroPerrosPorRazaStream());
	}
	private static void testGetPesoPorTamaño(Perros p) {
		System.out.println("Peso de los perros segun el tamaño: ");
		System.out.println(p.getPesoPorTamaño());
	}
	private static void testGetPerrosMenorPesoPorSexo(Perros p, Integer n) {
		System.out.println("Perros de menor tamaño segun el genero: ");
		System.out.println(p.getPerrosMenorPesoPorSexo(n));
	}
	
	private static void testGetMaxPesoPorTamaño(Perros p) {
		System.out.println("Maximo peso de los perros segun el tamaño: ");
		System.out.println(p.getMaxPesoPorTamaño());
	}
	
	private static void testMenorPesoPorSexo(Perros p) {
		System.out.println("Genero del perro de menor peso: ");
		System.out.println(p.MenorPesoPorSexo());
	}
	
	
	
	
	
	
	
	
	
	
}