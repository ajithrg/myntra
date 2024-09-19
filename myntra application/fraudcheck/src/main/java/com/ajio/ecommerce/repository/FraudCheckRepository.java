package com.ajio.ecommerce.repository;

import com.ajio.ecommerce.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckRepository extends JpaRepository<FraudCheckHistory,Integer> {
}
