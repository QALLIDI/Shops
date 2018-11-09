package com.qallidi.backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String nom;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Shop> preferred = new ArrayList<>();
	// @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL) 
	// private List<Shop> timers = new ArrayList<>();
	
	public User() {
		super();
	}
	
	public User(@NotNull String nom, @NotNull String email, @NotNull String password) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Shop> getPreferredShops() {
		return preferred;
	}

	public void setPreferred(List<Shop> preferred) {
		this.preferred = preferred;
	}
	/* like function */
	public boolean addToPreferredShop(Shop arg0) {
		return preferred.add(arg0);
	}

	public boolean contains(Object arg0) {
		return preferred.contains(arg0);
	}

	public boolean equals(Object arg0) {
		return preferred.equals(arg0);
	}

	public Shop get(int arg0) {
		return preferred.get(arg0);
	}

	public int indexOf(Object arg0) {
		return preferred.indexOf(arg0);
	}
	/* dislike function , needs to be hidden for 2h */
	public boolean removeFromPreferredShop(Object arg0) {
		return preferred.remove(arg0);
	}

	public int size() {
		return preferred.size();
	}
	
}
