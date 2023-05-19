
package fp.perros;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;





public class FactoriaPerros {
	
	public static Perros leerPerros(String rutaFichero) {
		Perros res=null;
		try {
			List<Perro>datos=Files.lines(Paths.get(rutaFichero), StandardCharsets.ISO_8859_1)
					.skip(1)
					.map(FactoriaPerros::parsearPerros)
					.collect(Collectors.toList() );
			res=new Perros(datos);
		}
		catch(IOException e) {
			System.out.println("Fichero no encontrado:" + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	

	

	
	private static Perro parsearPerros(String linea) {
		

		// Split por separador
		String[] trozos = linea.split(";");
		// Comprobar que tenemos tantos elementos en el array
		// como atributos esperamos
		if(trozos.length != 11) {
			throw new 
			IllegalArgumentException("Cadena no tiene "
					+ "formato vÃ¡lido");
		}
		
		Integer ID = Integer.valueOf(trozos[0].trim());
		String name = trozos[1].trim();
		Integer age=Integer.valueOf(trozos[2].trim());
		Genero sex= Genero.valueOf(trozos[3].trim().toUpperCase());
		List<String> breed=parsearLista(trozos[4].trim());
		LocalDate date_found=LocalDate.parse(trozos[5].trim(), 
				DateTimeFormatter.ofPattern("d/M/y"));
		LocalDate adoptable_from=LocalDate.parse(trozos[6].trim(), 
				DateTimeFormatter.ofPattern("d/M/y"));
		Pelaje coat=Pelaje.valueOf(trozos[7].trim().toUpperCase());
		Tamaño size = Tamaño.valueOf(trozos[8].trim().toUpperCase());
		Boolean neutered=parsearBooleano(trozos[9].trim());
		Double weight= Double.valueOf(trozos[10].trim());
		
		
		return new Perro(ID, name, age, sex , breed, date_found, adoptable_from, coat, size, neutered, weight);
	}
	
	private static Boolean parsearBooleano(String cadena) {
		Boolean res = null;
		
		if (cadena.equals("yes")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	private static List<String> parsearLista(String s){
		String[]linea=s.trim().split(",");
		List<String>res=new ArrayList<>();
		for(String st:linea) {
			res.add(st);
		}
		return res;
	}

}


