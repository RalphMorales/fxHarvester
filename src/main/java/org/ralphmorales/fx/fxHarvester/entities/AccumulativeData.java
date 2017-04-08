package org.ralphmorales.fx.fxHarvester.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accumulativeData")
public class AccumulativeData {
	
	private Long id;
	private String orderingCurrency;
	private Integer countOfDeals;
	
	public AccumulativeData(){}
	
	public AccumulativeData(String orderingCurrency, Integer countOfDeals) {
		this.orderingCurrency = orderingCurrency;
		this.countOfDeals = countOfDeals;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="orderingCurrency", nullable=false, unique=true)
	public String getOrderingCurrency() {
		return orderingCurrency;
	}

	public void setOrderingCurrency(String orderingCurrency) {
		this.orderingCurrency = orderingCurrency;
	}

	@Column(name="countOfDeals", nullable=false)
	public Integer getCountOfDeals() {
		return countOfDeals;
	}

	public void setCountOfDeals(Integer countOfDeals) {
		this.countOfDeals = countOfDeals;
	}

	
	
}
