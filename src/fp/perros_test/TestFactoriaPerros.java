package fp.perros_test;



import fp.perros.FactoriaPerros;

import fp.perros.Perros;


public class TestFactoriaPerros {
	public static void main(String[] args) {
		testLeerPerros("data\\Dogs.csv");
	}
	private static void testLeerPerros(String fichero) {
		
		System.out.println("\nTestLeerPerros =============");
		Perros p =FactoriaPerros.leerPerros(fichero);
		
		System.out.println("Perros: "+ p);
		
			
		
	}

	

}

