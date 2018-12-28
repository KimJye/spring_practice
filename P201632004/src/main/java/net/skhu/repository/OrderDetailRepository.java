package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Integer> {
}
