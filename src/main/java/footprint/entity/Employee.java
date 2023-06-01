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
	private String passWord;
	private String phone;
	private String address;
	private Boolean disable;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<Import> importEntity;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<Export> exports;

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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	

	public Employee(String idEmployee, String firstName, String lastName, String cccd, String email, String passWord,
			String phone, String address, Boolean disable, Collection<Import> importEntity,
			Collection<Export> exports) {
		this.idEmployee = idEmployee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cccd = cccd;
		this.email = email;
		this.passWord = passWord;
		this.phone = phone;
		this.address = address;
		this.disable = disable;
		this.importEntity = importEntity;
		this.exports = exports;
	}

	public Employee() {

	}

}
