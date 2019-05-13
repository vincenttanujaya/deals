package com.deals.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deals.api.model.Deals;
import com.deals.api.model.DealsRecord;

@Repository
public interface DealsRepository extends JpaRepository<Deals, Long> {
//	@Query(value = "SELECT * FROM deals d WHERE d.deals_exp >= now()", nativeQuery = true)
	@Query(value = "SELECT * FROM deals WHERE deals.id_deals NOT IN (SELECT d.id_deals FROM deals d LEFT JOIN (SELECT id_deals, COUNT(id_record_deals) as jumlah FROM `deals_record` WHERE id_customer=3 GROUP BY id_deals) J ON d.id_deals = j.id_deals WHERE j.jumlah>=d.deals_max_use) AND deals.deals_exp >= now()", nativeQuery = true)
    List<Deals> findAvailableDeals();

	@Query(value = "SELECT * FROM deals WHERE deals.id_deals NOT IN (SELECT d.id_deals FROM deals d LEFT JOIN (SELECT id_deals, COUNT(id_record_deals) as jumlah FROM `deals_record` WHERE id_customer=:id_customer GROUP BY id_deals) J ON d.id_deals = j.id_deals WHERE j.jumlah>=d.deals_max_use) AND deals.deals_exp >= now() AND deals.id_deals = :id_deals", nativeQuery = true)
    List<Deals> checkDeals(@Param("id_deals") int id_deals, @Param("id_customer") int id_customer);

}
