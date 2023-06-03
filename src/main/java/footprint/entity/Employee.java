package footprint.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	private String idEmployee;
	private String firstName;
	private String lastName;
	private String cccd;
	private String email;
	private String password;
	private String phone;
	private String address;
	private String role;
	private Boolean disable;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<Import> importEntity;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<Export> exports;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<Payment> payments;

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
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

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public Collection<Import> getImportEntity() {
		return importEntity;
	}

	public void setImportEntity(Collection<Import> importEntity) {
		this.importEntity = importEntity;
	}

	public Collection<Export> getExports() {
		return exports;
	}

	public void setExports(Collection<Export> exports) {
		this.exports = exports;
	}

	public Collection<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee(String idEmployee, String firstName, String lastName, String cccd, String email, String password,
			String phone, String address, String role, Boolean disable, Collection<Import> importEntity,
			Collection<Export> exports, Collection<Payment> payments) {
		this.idEmployee = idEmployee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cccd = cccd;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.disable = disable;
		this.importEntity = importEntity;
		this.exports = exports;
		this.payments = payments;
	}
	
	public Employee(String idEmployee, String firstName, String lastName, String cccd, String email, String password,
			String phone, String address, String role, boolean disable) {
		this.idEmployee = idEmployee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cccd = cccd;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.disable = disable;
	}

	public Employee() {

	}

}
