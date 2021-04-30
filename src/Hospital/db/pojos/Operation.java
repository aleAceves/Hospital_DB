package Hospital.db.pojos;

import java.io.Serializable;

import java.util.*;
import java.sql.Date;



public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1299176046471452179L;
	
	private Integer id;
	private String type;
	private Date date;
	private List<Surgeon> surgeons;
	private List<Nurse> nurses;
	
	
	//CONSTRUCTORS
	
	
	public Operation(Integer id, String type, Date date, List<Surgeon> surgeons, List<Nurse> nurses) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.surgeons = surgeons;
		this.nurses = nurses;
	}

	//Empty constructor
	public Operation() {
		super();
	}

	//Constructor without the lists
	public Operation(Integer id, String type, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
	}

	//Constructor without the id and the lists
	public Operation(String type, Date date) {
		super();
		this.type = type;
		this.date = date;
	}

	//TOSTRING METHOD
	@Override
	public String toString() {
		return "Operation [id=" + id + ", type=" + type + ", date=" + date + ", surgeons=" + surgeons + "]";
	}

	//GETTERS AND SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Surgeon> getSurgeons() {
		return surgeons;
	}

	public void setSurgeons(List<Surgeon> surgeons) {
		this.surgeons = surgeons;
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
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
		Operation other = (Operation) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surgeons == null) {
			if (other.surgeons != null)
				return false;
		} else if (!surgeons.equals(other.surgeons))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	// Added for convenience
	public void addSurgeon(Surgeon surgeon) {
		if (!surgeons.contains(surgeon)) {
			surgeons.add(surgeon);
		}
	}
	
	// Added for convenience
	public void removeSurgeon(Surgeon surgeon) {
		if (surgeons.contains(surgeon)) {
			surgeons.remove(surgeon);
		}
	}
	
	// Added for convenience
	public void addNurse(Nurse nurse) {
		if (!nurses.contains(nurse)) {
			nurses.add(nurse);
		}
	}
	
	// Added for convenience
	public void removeNurse(Nurse nurse) {
		if (nurses.contains(nurse)) {
			nurses.remove(nurse);
		}
	}
	
	

}
