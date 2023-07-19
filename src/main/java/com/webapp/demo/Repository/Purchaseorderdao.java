package com.webapp.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.demo.Model.PurchaseOrder;

public interface Purchaseorderdao extends JpaRepository<PurchaseOrder, Long> {
    
List<PurchaseOrder> findByProductId(Long id);
}
