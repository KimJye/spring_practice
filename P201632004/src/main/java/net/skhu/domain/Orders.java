package net.skhu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Orders {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employee_id")
	Employees employees;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customers customers;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="shipper_id")
	Shippers shippers;

	@JsonIgnore
	@OneToMany(mappedBy="orders")
	List<OrderDetails> orderDetails;

	@Column(name="order_date")
	Date orderDate;

	/*
	@Column(name="shipped_date")
	Date shippedDate;

	@Column(name="ship_name")
	String shipName;

	@Column(name="ship_address")
	String shipAddress;

	@Column(name="ship_city")
	String shipCity;

	@Column(name="ship_state_province")
	String shipStateProvince;

	@Column(name="ship_zip_postal_code")
	String shipZipPostalCode;

	@Column(name="ship_country_region")
	String shipCountryRegion;

	@Column(name="shipping_fee")
	BigDecimal shippingFee;

	BigDecimal taxes;

	@Column(name="payment_type")
	String paymentType;

	@Column(name="paid_date")
	Date paidDate;

	String notes;

	@Column(name="tax_rate")
	Double taxRate;


	@ManyToOne
	@JoinColumn(name="tax_status_id")
	OrderTaxStatus orderTaxStatus;

	@ManyToOne
	@JoinColumn(name="status_id")
	OrdersStatus ordersStatus;
*/





}
