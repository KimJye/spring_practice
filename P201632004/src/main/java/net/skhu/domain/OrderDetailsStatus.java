package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class OrderDetailsStatus {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name="status_name")
	String statusName;
}
