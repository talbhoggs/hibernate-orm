package model;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Embedded
	@AttributeOverrides(
			{@AttributeOverride(name="street", column=@Column(name="address_street")),
			 @AttributeOverride(name="city", column=@Column(name="address_city")),
			 @AttributeOverride(name="zipcode", column=@Column(name="address_zipcode")),
	})
	private Address address;
	
	
	
	// need to add default constructor
	// this is a must
	public Person(){}
	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
