package br.edu.infnet.cleancode.cleancode.model.entity;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public abstract class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "user")
	private List<Address> address;
	
	//private List<Apolice> apolices;
	
	

	public User() {
		super();
	}


	public User(long id, String name, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

//	public List<Apolice> getApolices() {
//		return apolices;
//	}
//
//	public void setApolices(List<Apolice> apolices) {
//		this.apolices = apolices;
//	}


}
