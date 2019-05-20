package com.deals.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "deals")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"Created_Date"}, 
        allowGetters = true)
public class Deals implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_deals;

    @Column(nullable = true)
    private String id_restoran;
    
	@NotBlank
    private String deals_name;

    @NotBlank
    private String deals_description;

    @NotBlank
    private String deals_exp;

    @NotBlank
    private String deals_start_date;

    @NotBlank
    private String deals_type;
    
    @NotBlank
    private String deals_max_use;

    @NotBlank
    private String deals_disc_type;

    @NotNull
    private float longitude;
    
    @NotNull
    private float latitude;
    
    public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Column(nullable = true)
    private int deals_discount;
    
    @Column(nullable = true)
    private int deals_max_value;
    
    @Column(nullable = true)
    private int deals_min_payment;
    
    @Column(nullable = true)
    private String deals_pict;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_date;

    public String getId_restoran() {
		return id_restoran;
	}

	public void setId_restoran(String id_restoran) {
		this.id_restoran = id_restoran;
	}
    
	public Long getId_deals() {
		return id_deals;
	}

	public void setId_deals(Long id_deals) {
		this.id_deals = id_deals;
	}

	public String getDeals_name() {
		return deals_name;
	}

	public void setDeals_name(String deals_name) {
		this.deals_name = deals_name;
	}

	public String getDeals_description() {
		return deals_description;
	}

	public void setDeals_description(String deals_description) {
		this.deals_description = deals_description;
	}

	public String getDeals_max_use() {
		return deals_max_use;
	}

	public void setDeals_max_use(String deals_max_use) {
		this.deals_max_use = deals_max_use;
	}

	public String getDeals_exp() {
		return deals_exp;
	}

	public void setDeals_exp(String deals_exp) {
		this.deals_exp = deals_exp;
	}

	public String getDeals_start_date() {
		return deals_start_date;
	}

	public void setDeals_start_date(String deals_start_date) {
		this.deals_start_date = deals_start_date;
	}

	public String getDeals_type() {
		return deals_type;
	}

	public void setDeals_type(String deals_type) {
		this.deals_type = deals_type;
	}

	public String getDeals_disc_type() {
		return deals_disc_type;
	}

	public void setDeals_disc_type(String deals_disc_type) {
		this.deals_disc_type = deals_disc_type;
	}

	public int getDeals_discount() {
		return deals_discount;
	}

	public void setDeals_discount(int deals_discount) {
		this.deals_discount = deals_discount;
	}

	public int getDeals_max_value() {
		return deals_max_value;
	}

	public void setDeals_max_value(int deals_max_value) {
		this.deals_max_value = deals_max_value;
	}

	public int getDeals_min_payment() {
		return deals_min_payment;
	}

	public void setDeals_min_payment(int deals_min_payment) {
		this.deals_min_payment = deals_min_payment;
	}

	public String getDeals_pict() {
		return deals_pict;
	}

	public void setDeals_pict(String deals_pict) {
		this.deals_pict = deals_pict;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

    
}
