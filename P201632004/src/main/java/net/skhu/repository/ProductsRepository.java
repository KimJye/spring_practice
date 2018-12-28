package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Products;
import net.skhu.model.Option;
import net.skhu.model.Pagination;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

	Option [] searchBy = {new Option(0,"검색 없음"), new Option(1,"제품명"),
			new Option(2,"카테고리")};

	Option [] orderBy = {new Option(0,"id"), new Option(1,"제품명"),
			new Option(2,"카테고리")};

	Sort[] sort = {new Sort(Sort.Direction.ASC,"id"),new Sort(Sort.Direction.ASC,"productName"),
			new Sort(Sort.Direction.ASC,"category")};

	public default List<Products> findAll(Pagination pagination){
		Pageable pageable =PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
		Page<Products> page;
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {
		case 0: page = this.findAll(pageable);break;
		case 1: page = this.findByProductNameStartsWith( searchText, pageable); break;
		case 2: page = this.findByCategoryContains( searchText, pageable); break;
		default: page = this.findAll(pageable); break;
		}
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}

	@Override
	public Page<Products> findAll(Pageable pageable);
	public Page<Products> findByProductNameStartsWith(String name, Pageable pageable);
	public Page<Products> findByCategoryContains(String category, Pageable pageable);
}
