package com.deals.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "deals_record")
@EntityListeners(AuditingEntityListener.class)
public class DealsRecord implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_record_deals;

    @Column(nullable = true)
    private int id_deals;
    
    @Column(nullable = true)
    private int id_customer;

	public Long getId_record_deals() {
		return id_record_deals;
	}

	public void setId_record_deals(Long id_record_deals) {
		this.id_record_deals = id_record_deals;
	}

	public int getId_deals() {
		return id_deals;
	}

	public void setId_deals(int id_deals) {
		this.id_deals = id_deals;
	}

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}   
    
}
