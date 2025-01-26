package cleytonorocha.com.github.back_dashboard.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cleytonorocha.com.github.back_dashboard.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
