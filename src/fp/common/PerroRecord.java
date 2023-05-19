package fp.common;

import java.util.Objects;

import fp.utiles.Checkers;

public record PerroRecord(Integer id, String name,Double weight) {
	
	//Constructor
	public PerroRecord{
		Checkers.check("El peso debe ser mayor que 0", weight>0);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerroRecord other = (PerroRecord) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(weight, other.weight);
	}
	
	

}
