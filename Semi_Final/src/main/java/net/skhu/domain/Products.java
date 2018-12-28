package net.skhu.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Products {

	//String suppliers_ids;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<OrderDetails> orderDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<PurchaseOrderDetails> purchaseOrderDetails;

	@Column(name="product_code")
	String productCode;

	@Column(name="product_name")
	String productName;

	String description;

	@Column(name="standard_cost")
	BigDecimal standardCost;

	@Column(name="list_price")
	BigDecimal listPrice;

	@Column(name="reorder_level")
	int reorderLevel;

	@Column(name="target_level")
	int targetLevel;

	@Column(name="quantity_per_unit")
	String quantityPerUnit;

	int discontinued;
	/*
	@Column(name="minimum__reorder_quantity")
	int minimumReorderQuantity;
	 */
	String category;

	@Basic(fetch=FetchType.LAZY)
	@Lob
	byte[] attachments;//첨부파일
}
