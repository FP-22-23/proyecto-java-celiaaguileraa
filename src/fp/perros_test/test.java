package fp.perros_test;

import java.time.LocalDate;



import java.util.List;

import fp.perros.Genero;
import fp.perros.Pelaje;
import fp.perros.Tamaño;
import fp.perros.Perro;


public class test {
	public static void main(String[] args) {
		
		////Constructores
		List<String> breed= List.of("Unknown Mix");
		Perro p1= new Perro(23807, "Gida", 25, Genero.FEMALE, breed, LocalDate.of(2019, 12, 10), LocalDate.of(2019,  12, 1), Pelaje.SHORT, Tamaño.SMALL, false, 11.14 );
		System.out.println(p1);
		List<String> breed2= List.of("Bull Terrier, Dachshund Mix");
		Perro p2= new Perro(532, "Fickó", 15, Genero.MALE, breed2, LocalDate.of(2019,  12, 1), LocalDate.of(2019,  12, 2), Pelaje.SHORT, Tamaño.MEDIUM, true, 14.14);
		System.out.println(p2);
		List<String> breed3= List.of("Vizsla Mix");
		Perro p3= new Perro(1222, "Vasi", 367, Genero.MALE, breed3, LocalDate.of(2019,  10, 25), LocalDate.of(2019,  10, 26), Pelaje.SHORT, Tamaño.MEDIUM, true, 46.77);
		System.out.println(p3);
		
		
		//Metodos set
		
		p1.setId(23806);
		p1.setName("Amy");
		p1.setAge(20);
		p1.setWeight(43.61);
		System.out.println(p1);
		System.out.println(p1.getName() + "" + p1.getId());
		
		//Metodos get
		System.out.println("\nId del perro:" + p1.getId());
		System.out.println("\nNombre del perro:" + p1.getName());
		System.out.println("\nEdad del perro:" + p1.getAge());
		System.out.println("\nGenero del perro:" + p1.getSex());
		System.out.println("\nRaza del perro:" + p1.getBreed());
		System.out.println("\nFecha en la que se encontro el perro:" + p1.getDate_found());
		System.out.println("\nFecha en la que se puede adoptar:" + p1.getAdoptable_from());
		System.out.println("\nPelahje del perro:" + p1.getCoat());
		System.out.println("\nTamaño del perro:" + p1.getSize());
		System.out.println("\nPerro castrado:" + p1.getNeutered());
		System.out.println("\nPeso del perro:" + p1.getWeight());
		
		//Metodo get de la propiedad derivada
		System.out.println("\nEl perro enconcontrado el "+ p1.getDate_found()+ "hace "+ p1.getAnyo() + " años que se encontró.");
		
		//Equals
		System.out.println("\nEl resultado del primer equals es"+p1.equals(p2));
		System.out.println("\nEl resultado del segundo equals es"+p2.equals(p3));
		
		//Compare to
		if(p1.compareTo(p3)>0) {
			System.out.println("\nEl perro " + p1.getName() + "va antes que el perro cuyo nombre es " + p3.getName());
			
			
		}else {
			System.out.println("\nEl perro " + p3.getName() + "va antes que el perro cuyo nombre es " + p1.getName());
		}
		
		
	}
}
		
		
		
