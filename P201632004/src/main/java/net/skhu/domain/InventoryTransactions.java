package net.skhu.domain;

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
@Table(name = "inventory_transactions")
public class InventoryTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/*
	@ManyToOne
	@JoinColumn(name = "transaction_type")
	InventoryTransactionTypes inventoryTransactionsTypes;
	*/
	@Column(name="transaction_created_date")
	Date transactionCreatedDate;

	@Column(name="transaction_modified_date")
	Date transactionModifiedDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Products products;

}
