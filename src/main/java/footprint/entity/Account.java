package footprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue
	private Long idAccount;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String imageUrl;
	private String email;
	private String phone;

	@Column(name = "createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	private Boolean disable;

	@ManyToOne
	@JoinColumn(name = "idRole")
	private Role role;
	
	// chứa thông tin cart của account.  
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private Collection<Cart> carts;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private Collection<OrderCT> orders;

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	public Collection<OrderCT> getOrders() {
		return orders;
	}

	public void setOrders(Collection<OrderCT> orders) {
		this.orders = orders;
	}

	public Account() {};
	public Account(Long idAccount, String username, String password, String firstName, String lastName, String address,
			String imageUrl, String email, String phone, Date createAt, Boolean disable, Role role,
			Collection<Cart> carts, Collection<OrderCT> orders) {
		this.idAccount = idAccount;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.imageUrl = imageUrl;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
		this.disable = disable;
		this.role = role;
		this.carts = carts;
		this.orders = orders;
	}

	public Account(Role role, String lastName, String firstName, String email, String phone, String imageUrl, String password, String username) {
		this.role = role;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.disable = null;
		this.password = password;
		this.username = username;
	}
}
