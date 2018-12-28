package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.Orders;
import net.skhu.model.Option;
import net.skhu.model.Search;

public interface OrdersRepository extends JpaRepository<Orders,Integer>{
	Option [] searchBy = {new Option(0,"검색 없음"), new Option(1,"직원이름"),
			new Option(2,"고객이름")};

	public default List<Orders> findAll(Search search){
		Pageable pageable =PageRequest.of(search.getPg() - 1, search.getSz());
		Page<Orders> page;
		String searchText = search.getSt();
		switch (search.getSb()) {
		case 0: page = this.findAll(pageable);break;
		case 1: page = this.findByEmployeeName( searchText,pageable); break;
		case 2: page = this.findByCustomerName( searchText,pageable); break;
		default: page = this.findAll(pageable); break;
		}
		/*
		switch(ob) {
		case 0 : list = this.findAll();break;
		case 1 : list = this.findByEmployeesId(); break;
		case 2 : list = this.findByCustomersId(); break;
		case 3 : list = this.findByShippersId();break;
		default : list = this.findAll();break;
		}
		*/
		search.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}

	@Override
	public Page<Orders> findAll(Pageable pageable);

	@Query("select o from Orders o where o.employees.lastName like CONCAT('%',:searchText,'%')")
	public Page<Orders> findByEmployeeName(String searchText,Pageable pageable);

	@Query("select o from Orders o where o.customers.lastName  like CONCAT('%',:searchText,'%')")
	public Page<Orders> findByCustomerName(String searchText,Pageable pageable);


	@Query("select o.employees.id from Orders o")
	public List<Orders> findByEmployeesId();

	@Query("select o.customers.id from Orders o")
	public List<Orders> findByCustomersId();

	@Query("select o.shippers.id from Orders o")
	public List<Orders> findByShippersId();
}
