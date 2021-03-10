package Hospital.db.pojos;

import java.io.Serializable;
import java.util.*;


public class Nurse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6716901127357966335L;
	
	private Integer id;
	private String name;
	private String surname;
	private List<Operation> operations;
	
	//CONSTRUCTOR
	public Nurse(Integer id, String name, String surname, List<Operation> operations) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.operations = operations;
	}

	//TOSTRING METHOD
	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", surname=" + surname + ", operations=" + operations + "]";
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

	//EQUALS METHOD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nurse other = (Nurse) obj;
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
		if (operations == null) {
			if (other.operations != null)
				return false;
		} else if (!operations.equals(other.operations))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
	
	
}
