package fp.perros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Genero;
import fp.common.Pelaje;
import fp.common.Tamaño;

public class Perros{
    private List<Perro> perros;

    public Perros(Collection<Perro>perros) {
        this.perros = new ArrayList<Perro>(perros);
    }
//Constructores    
    public Perros() {
    	this.perros=new ArrayList<Perro>();
    }
    
    public Perros(List<Perro>p) {
        this.perros = p;
    }

    public Perros(Stream<Perro>perros) {
    	this.perros=perros.collect(Collectors.toList());
    }
        

    
//añade un elemento
    public void addPerro(Perro perro) {
        perros.add(perro);
    }
//añade a una lista
    public void addPerros(List<Perro> perros) {
        perros.addAll(perros);
    }
//elimina perro
    public void removePerro(Perro perro) {
        perros.remove(perro);
    }
//obtener numero elementos
    public int countPerros() {
        return perros.size();
    }
//equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perros that = (Perros) o;
        return Objects.equals(perros, that.perros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perros);
    }
//tostring
    @Override
    public String toString() {
        return "PerrosContainer{" +
                "perrosList=" + perros +
                '}';
    }
    
    //TRATAMIENTOS SECUENCIALES
    
    //existe
    public Boolean existe(Integer id) {
    	Boolean res= false;
        for (Perro perro : perros) {
            if (Arrays.asList(perro.getId()).contains(id)) {
                res =true;
                break;
            }
        }
        return res;
    }
    
    
    
    //media del peso de los perros segun el tamaño del perro(enumerado)
    
    public Double getMediaPesoSegunTamaño(Tamaño size) {
    	Double res=0.0;
		Double suma =0.0;
		Integer cont = 0;
		for (Perro p: perros) {
			if (p.getSize().equals(size)) {
				suma+= p.getWeight();
				cont++;
			}
		if (cont>0) {
			res = suma/cont;
			}
		}
		return res;
	
    }
    
   public List<Integer> filtraPorPerrosVacunados(){
    	List<Integer>res=new ArrayList<>();
    	for(Perro e: this.perros) {
    		if(e.getNeutered().equals(true)) {
    			res.add(e.getId());
    		}
    		
    	}
    	return res;
    }
    
    
    public Map<Double, List<Perro>>getListaPorPeso(){
    	Map<Double, List<Perro>>res=new HashMap<>();
    	for(Perro p :perros) {
    		Double key=p.getWeight();
    		if(res.containsKey(key)) {
    			res.get(key).add(p);
    		}else {
    			List<Perro>valor=new ArrayList<>();
    			valor.add(p);
    			res.put(key, valor);
    		}
    	}
    	return res;
    }
    

	
    

}