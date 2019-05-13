package com.deals.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.deals.api.model.DealsRecord;

@Repository
public interface DealsRecordRepository extends JpaRepository<DealsRecord, Long> {
	
}
