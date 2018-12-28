package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_status")
public class OrdersStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;//Byte

	@Column(name="status_name")
	String statusName;
}
