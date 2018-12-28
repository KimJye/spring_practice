package net.skhu.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Invoices {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	 @OneToOne
	 @JoinColumn(name="order_id")
	 Orders orders;

	@Column(name="invoice_date")
	 Date invoiceDate;

	@Column(name="due_date")
	 Date dueDate;

	 BigDecimal tax;
	 BigDecimal shipping;

	@Column(name="amount_due")
	 BigDecimal amountDue;
}
