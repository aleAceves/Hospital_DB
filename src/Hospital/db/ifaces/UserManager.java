package Hospital.db.ifaces;

import java.util.List;

import Hospital.db.pojos.users.*;
import Hospital.db.pojos.users.Role;





public interface UserManager {

	public void connect();

	public void disconnect();

	public void createUser(User user);

	public void createRole(Role role);

	public Role getRole(int id);

	public Role getRoleByName(String roleName);

	public List<Role> getRoles();

	public User checkPassword(String username, String password);

	void newUser(User u);

	void newRole(Role role);

}

	


