package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

}
