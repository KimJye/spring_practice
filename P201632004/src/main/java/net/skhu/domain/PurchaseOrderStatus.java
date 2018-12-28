package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "purchas_order_status")
public class PurchaseOrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String status;
}
