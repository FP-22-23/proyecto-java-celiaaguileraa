package fp.perros;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Perros{
    private List<Perro> perros;
    
  //Constructores    
    public Perros(Collection<Perro>perros) {
        this.perros = new ArrayList<Perro>(perros);
    }
   
    public Perros() {
    	this.perros=new ArrayList<Perro>();
    }
    
    //Getters and setters
    public List<Perro> getPerros() {
        return perros;
    }

    public void setPerros(List<Perro>perros) {
    	this.perros=perros;
    }
    
    //Equals
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perros other = (Perros) obj;
		return Objects.equals(perros, other.perros);
	}

    //Hashcode
    @Override
	public int hashCode() {
		return Objects.hash(perros);
	}
    
    
    //Método toString
    @Override
	public String toString() {
		return "Perros [perros=" + perros + "]";
	}
    
      
  //Obtiene numero elementos
    public int getNumeroPerros() {
        return perros.size();
    }       

 //Añade un elemento
    public void addPerro(Perro p) {
        perros.add(p);
    }
//Añade a una lista
    public void addPerros(Collection<Perro> p) {
        perros.addAll(p);
    }
//Elimina perro
    public void removePerro(Perro p) {
        perros.remove(p);
    }


    
   
   //TRATAMIENTOS SECUENCIALES
    
    //Entrega 2
    //Existe
    //1
    public Boolean existeIdPerro(Integer id) {
    	Boolean res= false;
        for (Perro perro : perros) {
            if (Arrays.asList(perro.getId()).contains(id)) {
                res =true;
                break;
            }
        }
        return res;
    }
    
    
    
    //Msedia del peso de los perros segun el tamaño del perro(enumerado)
    //2
    
	public Double getMediaPesoSegunTamaño(Tamaño size) {
    	Double res=0.0;
		Double suma =0.0;
		Integer cont = 0;
		for (Perro p: perros) {
			if (p.getSize().equals(size)) {
				suma+= p.getWeight();
				cont++;
			}}
		if (cont !=0) {
			res = suma/cont;
			return res;
			}
		else {
			return null;
		}
		
	
    }
    
	//3 Filtrado segun la vacunacion de los perros
   public List<Integer> filtraPorPerrosCastrados(){
    	List<Integer>res=new ArrayList<>();
    	for(Perro e: this.perros) {
    		if(e.getNeutered().equals(true)) {
    			res.add(e.getId());
    		}
    		
    	}
    	return res;
    }
    
    //4 
    public Map<Double, List<Perro>>getListaPorPeso(){
    	Map<Double, List<Perro>>res=new HashMap<Double,List<Perro>>();
    	for(Perro p :perros) {
    		Double key=p.getWeight();
    		if(res.containsKey(key)) {
    			List<Perro>value=res.get(key);
    			value.add(p);
    			res.put(key,  value);
    		}else {
    			List<Perro>value=new ArrayList<>();
    			value.add(p);
    			res.put(key, value);
    		}
    	}
    	return res;
    }
    //5 Numero de perros por raza
    public Map<List<String>, Integer> getNumeroPerrosPorRaza(){
    	Map<List<String>, Integer> res=new HashMap<List<String>, Integer>();
    	for (Perro p:perros) {
    		List<String> key=p.getBreed();
    		
    		if(res.containsKey(key)) {
    			Integer value=res.get(key);
    			value ++;
    			res.put(key, value);
    		}
    		else {
    			Integer value=1;
    			res.put(key, value);
    		}
    		
    	}
    	return res;
    	
    }


	
    



//3 ENTREGA

//BLOQUE 1

    //Existe stream
    public Boolean existeStream(Integer id) {
    	Boolean res=perros.stream().anyMatch(p->p.getId().equals(id));
    	return res;
    	
    }
    
    //Media de peso de los perros pequeños(Stream)
    public Double getMediaPesoSegunTamañoStream(Tamaño size) {
    	OptionalDouble res=perros.stream()
    			.filter(p->p.getSize().equals(size))
    			.mapToDouble(p->p.getWeight())
    			.average();
    	return res.orElse(0.);

    }
    //filtrado de perros vacunados(Stream)
    public List<Integer> filtraPorPerrosCastradosStream(){
    	List<Integer>res=perros.stream()
    			.filter(p->p.getNeutered().equals(true))
    			.map(Perro::getId)
    			.collect(Collectors.toList());
    	return res;
    }
  //Un máximo/mínimo con filtrado
  //Perro de tamaño pequeño con mayor peso

  public Perro getPerroPequeñoMaxPesoStream(Tamaño t) {
  	Perro res=perros.stream()
  			.filter(p->p.getSize().equals(Tamaño.SMALL))
  			.max(Comparator.comparing(Perro::getWeight))
  			.orElse(null);
  	return res;
  	}
  //Una selección, con filtrado y ordenación.
  public Set<Perro> getPerrosMachosCastradosOrdenadoFechaEncontrados() {
	Set<Perro>res=perros.stream()
			.filter(p->p.getNeutered().equals(true))
			.filter(p->p.getSex().equals(Genero.MALE))
			.sorted(Comparator.comparing(Perro::getDate_found))
			.collect(Collectors.toSet());
	return res;
	
}
  
  //BLOQUE 2
  
  //metodo 5 con stream (contador)
  public Map<List<String>, Long> getNumeroPerrosPorRazaStream(){
	  return perros.stream()
			  .collect(Collectors.groupingBy(Perro::getBreed, Collectors.counting()));
	  
  }
  
  //Un método en cuya implementación se use, o bien el Collector collectingAndThen,
  //o bien el Collector mapping.
  
  public Map<Tamaño, Set<Double>>getPesoPorTamaño() {
	  return perros.stream()
			  .collect(Collectors.groupingBy(Perro::getSize, 
					  Collectors.mapping(Perro::getWeight, Collectors.toSet())));
  }
  
  //Un método que devuelva un Map en el que las claves sean un atributo o una función
  //sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
  
  public Map<Tamaño, Double> getMaxPesoPorTamaño(){
	  Map<Tamaño, Set<Double>>res=perros.stream()
			  .collect(Collectors.groupingBy(Perro::getSize,Collectors.mapping(Perro::getWeight, Collectors.toSet()))); 
	  
	  return res.entrySet().stream()
	            .collect(Collectors.toMap(
	                  entry->entry.getKey(),
	                    entry -> Collections.max(entry.getValue())));
	            
  
  }
  
  //Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, 
  //y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo 
  //(o función sobre el atributo).
  
    public SortedMap<Genero, List<Double>> getPerrosMenorPesoPorSexo(Integer n){
    	return perros.stream()
    			.collect(Collectors.groupingBy(Perro::getSex,TreeMap::new,
						Collectors.collectingAndThen(Collectors.toSet(),
								p->nPerrosMenorPeso(p,n))));
    }
    
    //creamos una lista con los n perros de menor peso
    public List<Double> nPerrosMenorPeso(Collection<Perro>p, Integer n){
    	return p.stream()
    			.sorted(Comparator.comparing(Perro::getWeight))
    			.limit(n)
    			.map(Perro::getWeight)
    			.collect(Collectors.toList());
    }
    
    
    //Un método que calcule un Map y devuelva la clave con 
    //el valor asociado (mayor o menor) de todo el Map.
    
    public Genero MenorPesoPorSexo() {
    	Map<Genero, Set<Double>> aux = perros.stream()
    			.collect(Collectors.groupingBy(Perro::getSex,Collectors.mapping(Perro::getWeight, Collectors.toSet())));
    	return aux.entrySet().stream()
    	        .min(Comparator.comparing(entry -> entry.getValue()
    	                .stream()
    	                .min(Double::compareTo)
    	                .orElse(0.0))) // Valor por defecto si no hay valores
    	        .map(Map.Entry::getKey)
    	        .orElse(null);

    	}
    	

}

