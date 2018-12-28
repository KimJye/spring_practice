package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.Customers;
import net.skhu.model.Option;
import net.skhu.model.Pagination;

public interface CustomersRepository extends JpaRepository<Customers,Integer>{
	Option [] searchBy = {new Option(0,"검색 없음"), new Option(1,"이름"),
			new Option(2,"직위"), new Option(3,"도시")};

	Option [] orderBy = {new Option(0,"id"), new Option(1,"직위"),
			new Option(2,"도시")};

	Sort[] sort = {new Sort(Sort.Direction.ASC,"id"),new Sort(Sort.Direction.ASC,"jobTitle"),
			new Sort(Sort.Direction.ASC,"city")};

	public default List<Customers> findAll(Pagination pagination){
		Pageable pageable =PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
		Page<Customers> page;
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {
		case 0: page = this.findAll(pageable);break;
		case 1: page = this.findByName( searchText, pageable); break;
		case 2: page = this.findByJobTitleContains( searchText, pageable); break;
		case 3: page = this.findByCityStartsWith( searchText, pageable); break;
		default: page = this.findAll(pageable); break;
		}
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}

	@Override
	public Page<Customers> findAll(Pageable pageable);

	@Query("select c from Customers c where c.lastName like CONCAT('%',:name,'%') or c.firstName like CONCAT('%',:name,'%')")
	public Page<Customers> findByName(@Param("name") String name,Pageable pageable);

	public Page<Customers> findByJobTitleContains(String jobTitle, Pageable pageable);
	public Page<Customers> findByCityStartsWith(String city, Pageable pageable);
}
