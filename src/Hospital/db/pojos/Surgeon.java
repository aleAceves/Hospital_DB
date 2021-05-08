package Hospital.db.pojos;

import java.io.Serializable;

import java.util.*;

public class Surgeon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6144782680389185618L;
	
	private Integer id;
	private String name;
	private String surname;
	private String speciality;
	private List<Operation> operations;
	
	
	
	// CONSTRUCTORS
	
	//With all the variables
	public Surgeon(Integer id, String name, String surname, String speciality, List<Operation> operations) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.operations = operations;
	}
	
	//Empty constructor
	public Surgeon() {
		super();
	}

	//Without the id
	public Surgeon(String name, String surname, String speciality, List<Operation> operations) {
		super();
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.operations = operations;
	}

	//Constructor without the list of operations
	public Surgeon(Integer id, String name, String surname, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
	}

	//Constructor without the id and operations
	public Surgeon(String name, String surname, String speciality) {
		super();
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
	}

	//TO STRING METHOD
	@Override
	public String toString() {
		return "Surgeon [id=" + id + ", name=" + name + ", surname=" + surname + ", speciality=" + speciality + "]";
	}


	//GETTERS AND SETTERS
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	//HASHCODE METHOD
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	// EQUALS METHOD

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Surgeon other = (Surgeon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	

	
	
	
}
