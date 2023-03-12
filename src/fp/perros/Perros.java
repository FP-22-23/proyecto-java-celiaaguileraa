package fp.perros;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.common.Genero;
import fp.common.Pelaje;
import fp.common.Tamaño;
import fp.utiles.Checkers;

public class Perros {
	private Integer id;
	private String name;
	private Integer age;
	private Genero sex;
	private List<String> breed;
	private LocalDate date_found;
	private LocalDate adoptable_from;
	private Pelaje coat;
	private Tamaño size;
	private Boolean neutered;
	private Double weight;
	
	//Constructor
	public Perros(Integer id, String name, Integer age, Genero sex, 
			List<String> breed, LocalDate date_found, LocalDate adoptable_from, 
			Pelaje coat, Tamaño size, Boolean neutered, Double weight) {
		
		Checkers.check("No hay perros adoptables con esa edad", age>5 );
		Checkers.check("No hay perros que pesen mas de 50 kilos", weight<=50);
		
		//Checkers.check("La fecha permitida para adoptar no puede ser anterior a la fecha en la que se encontró el perro",
				//adoptable_from.isAfter(date_found));
		this.id=id;
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.breed=breed;
		this.date_found=date_found;
		this.adoptable_from=adoptable_from;
		this.coat=coat;
		this.size=size;
		this.neutered=neutered;
		this.weight=weight;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Genero getSex() {
		return sex;
	}

	public void setSex(Genero sex) {
		this.sex = sex;
	}

	public List<String> getBreed() {
		return breed;
	}

	public void setBreed(List<String> breed) {
		this.breed = breed;
	}

	public LocalDate getDate_found() {
		return date_found;
	}

	public void setDate_found(LocalDate date_found) {
		this.date_found = date_found;
	}

	public LocalDate getAdoptable_from() {
		return adoptable_from;
	}

	public void setAdoptable_from(LocalDate adoptable_from) {
		this.adoptable_from = adoptable_from;
	}

	public Pelaje getCoat() {
		return coat;
	}

	public void setCoat(Pelaje coat) {
		this.coat = coat;
	}

	public Tamaño getSize() {
		return size;
	}

	public void setSize(Tamaño size) {
		this.size = size;
	}

	public Boolean getNeutered() {
		return neutered;
	}

	public void setNeutered(Boolean neutered) {
		this.neutered = neutered;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Integer getAnyo() {
		return date_found.until(LocalDate.now()).getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(adoptable_from, age, breed, coat, date_found, id, name, neutered, sex, size, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perros other = (Perros) obj;
		return Objects.equals(adoptable_from, other.adoptable_from) && Objects.equals(age, other.age)
				&& Objects.equals(breed, other.breed) && coat == other.coat
				&& Objects.equals(date_found, other.date_found) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(neutered, other.neutered) && sex == other.sex
				&& size == other.size && Objects.equals(weight, other.weight);
	}

	@Override
	public String toString() {
		return "Perros [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", breed=" + breed
				+ ", date_found=" + date_found + ", adoptable_from=" + adoptable_from + ", coat=" + coat + ", size="
				+ size + ", neutered=" + neutered + ", weight=" + weight + "]";
	}
	
	public int compareTo(Perros p) {
		int r = this.getId().compareTo(p.getId());
		if(r == 0) {
			r = this.getName().compareTo(p.getName());
		}
		return r;
	}
	
	

	

}
