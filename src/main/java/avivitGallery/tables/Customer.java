package avivitGallery.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;

	@Column
	private String name;

	@Id
	@Column
	private String email;

	@Column
	private long phone;

	public Customer() {

	}

	public Customer(int iD, String name, String email, long phone) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", name=" + name + ", email=" + email + ",phone=" + phone + "]";
	}

}
