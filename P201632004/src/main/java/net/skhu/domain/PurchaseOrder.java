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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	Suppliers suppliers;

	@OneToOne
	@JoinColumn(name = "created_by")
	Employees employees;

	@Column(name="submitted_date")
	Date submittedDate;

	@Column(name="creation_date")
	Date creationDate;

	@ManyToOne
	@JoinColumn(name = "status_id")
	Suppliers statusId;

	@Column(name="expected_date")
	Date expectedDate;

	@Column(name="shipping_fee")
	BigDecimal shippingFee;

	BigDecimal taxes;

	@Column(name="payment_date")
	Date paymentDate;

	@Column(name="payment_amount")
	BigDecimal paymentAmount;

	@Column(name="payment_method")
	String paymentMethod;

	String notes;

	@Column(name="approved_by")
	int approvedBy;

	@Column(name="approved_date")
	Date approvedDate;

	@Column(name="submitted_by")
	int submittedBy;






}
