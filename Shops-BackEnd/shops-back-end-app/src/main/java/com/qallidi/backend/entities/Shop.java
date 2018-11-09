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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SHOP")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String shop;
	@NotNull
	private double distance;
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();

	public Shop(long id, String shop, double distance) {
		super();
		this.id = id;
		this.shop = shop;
		this.distance = distance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "Shop [id=" + id + ", shop=" + shop + ", distance=" + distance + "]";
	}
	/* compare shops by distance , used in method sorted (controller) */
	public int compareByDistance(Shop s) {
		int result = 0;
		double var = this.getDistance() - s.getDistance();
		result = (int) var;
		return result;
	}
}
