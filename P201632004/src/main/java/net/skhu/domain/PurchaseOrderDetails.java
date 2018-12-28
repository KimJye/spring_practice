package net.skhu.domain;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "purchase_order_details")
public class PurchaseOrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "purchase_order_id")
	PurchaseOrder purchaseOrder;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Products products;

	BigDecimal quantity;

	@Column(name="unti_cost")
	BigDecimal untiCost;

	@Column(name="date_received")
	Date dateReceived;

	@Column(name="posted_to_inventory")
	int postedToInventory;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	InventoryTransactions inventoryTransactions;

}
