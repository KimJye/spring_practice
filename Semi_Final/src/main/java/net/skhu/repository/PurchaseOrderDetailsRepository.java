package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.PurchaseOrderDetails;

public interface PurchaseOrderDetailsRepository extends JpaRepository<PurchaseOrderDetails, Integer>{

}