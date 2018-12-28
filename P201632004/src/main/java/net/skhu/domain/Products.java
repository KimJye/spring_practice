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
	Integer id;

	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<OrderDetails> orderDetails;

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
	Integer reorderLevel;

	@Column(name="target_level")
	Integer targetLevel;

	@Column(name="quantity_per_unit")
	String quantityPerUnit;

	Integer discontinued;

	@Column(name="minimum_reorder_quantity")
	Integer minimumReorderQuantity;

	String category;

	@Basic(fetch=FetchType.LAZY)
	@Lob
	byte[] attachments;//첨부파일
}
