package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.Orders;
import net.skhu.model.Option;

public interface OrdersRepository extends JpaRepository<Orders,Integer>{
	Option [] searchBy = {new Option(0,"검색 없음"), new Option(1,"직원이름"),
			new Option(2,"고객이름"), new Option(3,"배송자이름")};

	Option [] orderBy = {new Option(0,"직원 오름차순"), new Option(1,"고객 오름차순"),
			new Option(2,"배송자 오름차순")};

	public default List<Orders> findAll(String searchText, int sb,int ob){
		List<Orders> list = null;

		switch (sb) {
		case 0: list = this.findAll();break;
		case 1: list = this.findByEmployeeName( searchText); break;
		case 2: list = this.findByCustomerName( searchText); break;
		case 3: list = this.findByShipperName( searchText); break;
		default: list = this.findAll(); break;
		}
		switch(ob) {
		case 0 : list = this.findAll();break;
		case 1 : list = this.findByEmployeesId(); break;
		case 2 : list = this.findByCustomersId(); break;
		case 3 : list = this.findByShippersId();break;
		default : list = this.findAll();break;
		}
		return list;
	}


	@Query("select o from Orders o where o.employees.lastName = :searchText")
	public List<Orders> findByEmployeeName(String searchText);

	@Query("select o from Orders o where o.customers.lastName = :searchText")
	public List<Orders> findByCustomerName(String searchText);

	@Query("select o from Orders o where o.shippers.lastName = :searchText")
	public List<Orders> findByShipperName( String searchText);

	@Query("select o.employees.id from Orders o")
	public List<Orders> findByEmployeesId();

	@Query("select o.customers.id from Orders o")
	public List<Orders> findByCustomersId();

	@Query("select o.shippers.id from Orders o")
	public List<Orders> findByShippersId();
}
