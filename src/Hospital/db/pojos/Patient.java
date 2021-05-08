package Hospital.db.pojos;

import java.io.Serializable;


public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2103717344076011347L;
	
	private Integer id;
	private String name;
	private String surname;
	private String address;
	private String email;
	
	//CONSTRUCTORS
	public Patient(Integer id, String name, String surname, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
	}
	
	
	//Constructor without the id
	public Patient(String name, String surname, String address, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
	}



	//TOSTRING METHOD
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", email="
				+ email + "]";
	}
	
	// GETTERS AND SETTERS
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		Patient other = (Patient) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
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
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}
