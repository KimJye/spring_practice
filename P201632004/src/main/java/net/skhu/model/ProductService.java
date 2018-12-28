package net.skhu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Products;
import net.skhu.repository.ProductsRepository;

@Service
public class ProductService {
	@Autowired
	public ProductsRepository productRepository;

	public Products updateEntity(ProductEditModel productModel,int id) {
		Products product = productRepository.findById(id).get();

		product.setProductCode(productModel.getProductCode());
		product.setProductName(productModel.getProductName());
		product.setStandardCost(productModel.getStandardCost());
		product.setListPrice(productModel.getListPrice());
		product.setQuantityPerUnit(productModel.getQuantityPerUnit());
		product.setCategory(productModel.getCategory());
		product.setDescription(product.getDescription());
		product.setReorderLevel(product.getReorderLevel());
		product.setTargetLevel(product.getTargetLevel());
		product.setDiscontinued(product.getDiscontinued());
		product.setMinimumReorderQuantity(product.getMinimumReorderQuantity());
		return product;
	}

	public void save(ProductEditModel productModel,int id) {
		Products product = updateEntity(productModel,id);
		productRepository.save(product);
	}
}
