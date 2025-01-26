package cleytonorocha.com.github.back_dashboard.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cleytonorocha.com.github.back_dashboard.model.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
