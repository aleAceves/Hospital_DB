package Hospital.db.pojos;

import java.io.Serializable;
import java.util.*;

public class Operating_room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5277218931172634444L;
	
	private Integer id;
	private Integer number;
	
	
	// CONSTRUCTOR
	public Operating_room(Integer id, Integer number) {
		super();
		this.id = id;
		this.number = number;
	}
	
	//TO STRING METHOD
	@Override
	public String toString() {
		return "Operating_room [id=" + id + ", number=" + number + "]";
	}
	
	//GETTERS AND SETTERS
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
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
		Operating_room other = (Operating_room) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	

}
