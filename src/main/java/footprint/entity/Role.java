
package footprint.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "role")
public class Role {

	@Id
	private String idRole;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Collection<Account> accounts;

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Account> getUsers() {
		return accounts;
	}

	public void setUsers(Collection<Account> users) {
		this.accounts = users;
	}

	public Role() {

	}

	public Role(String idRole, String name, Collection<Account> users) {
		this.idRole = idRole;
		this.name = name;
		this.accounts = users;
	}
	
	

}
