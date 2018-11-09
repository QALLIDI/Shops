package com.qallidi.backend.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TIMER") 
public class Timer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private LocalDate startTime;
	@NotNull
	private LocalDate finishTime;
	@OneToOne
	private Shop shop;
	@ManyToOne()
	private User user;
	public Timer() {
		super();
	}

	public Timer(@NotNull LocalDate startTime, Shop shop) {
		super();
		this.startTime = startTime;
		this.shop = shop;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDate finishTime) {
		this.finishTime = finishTime;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Timer [id=" + id + ", startTime=" + startTime + ", finishTime=" + finishTime + ", shop=" + shop + "]";
	}
}
