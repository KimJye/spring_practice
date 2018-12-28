package net.skhu.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class ProductEditModel {

	@NotEmpty
	@Size(min=3, max=20)
	@Column(name="product_code")
	String productCode;

	@NotEmpty
	@Size(min=5, max=50)
	@Column(name="product_name")
	String productName;


	@Column(name="standard_cost")
	BigDecimal standardCost;


	@Column(name="list_price")
	BigDecimal listPrice;

	@Column(name="quantity_per_unit")
	String quantityPerUnit;

	String category;
}
