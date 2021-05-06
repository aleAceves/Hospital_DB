package Hospital.db.ifaces;

import Hospital.db.pojos.users.Role;
import Hospital.db.pojos.users.User;
	

import java.util.List;



public interface UserManager {

	public void connect();
	public void disconnect();
	public void newUser(User u);
	public void newRole(Role r);
	public javax.management.relation.Role getRole(int id);
	public List<Role> getRoles();
	public User checkPassword(String email, String password);
}

	


