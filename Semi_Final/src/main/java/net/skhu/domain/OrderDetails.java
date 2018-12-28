package net.skhu.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	Orders orders;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Products products;

	BigDecimal quantity;

	@Column(name="unit_price")
	BigDecimal unitPrice;

	//Double discount;

	/*
	@ManyToOne
	@JoinColumn(name = "status_id")
	OrdersStatus orderstatus;

	@Column(name="date_allocated")
	Date dateAllocated;

	@Column(name="purchase_order_id")
	int purchaseOrderId;

	@Column(name="inventory_id")
	int inventoryId;
	*/



}
