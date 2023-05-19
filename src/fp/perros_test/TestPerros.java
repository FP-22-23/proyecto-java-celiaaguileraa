package fp.perros_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fp.common.Tamaño;
import fp.perros.FactoriaPerros;
import fp.perros.Perro;
import fp.perros.Perros;

public class TestPerros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Perros p = FactoriaPerros.leerPerros("data/Dogs.csv");
		 System.out.println("Perros: " + p);
		 
		 //test existe
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de existe");
		 testExiste(p);
		 
		 //test media
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getMediaPesoSegunTamaño");
		 testGetMediaPesoSegunTamaño(p, Tamaño.LARGE);
		 
		 //Test filtro
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de filtraPorPerrosVacunados");
		 testFiltraPorPerrosVacunados(p);
		 
		 //Test agrupacion
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getListaPorPeso");
		 testGetListaPorPeso(p);
	}
		 
		 
		

	private static void testGetListaPorPeso(Perros p) {
		Map<Double, List<Perro>>res=p.getListaPorPeso();
		System.out.println("La lista según el peso es:");
		System.out.println(res);
		
	}

	private static void testFiltraPorPerrosVacunados(Perros p) {
		List<Integer>res=p.filtraPorPerrosVacunados();
		System.out.println("El id de los perros vacunados son: ");
		System.out.println(res);
	}
		
		
	//}

	private static void testGetMediaPesoSegunTamaño(Perros p, Tamaño t) {
		Double Media=p.getMediaPesoSegunTamaño(t);
		System.out.println("La media del peso segun tamaño es: ");
		System.out.println(Media);
		
	}

	private static void testExiste(Perros p) {
		System.out.println("Existe?");
		System.out.println(p.Existe(p));
		
		
		
		
	}
		 

}
