package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.Employees;
import net.skhu.model.Option;

public interface EmployeesRepository extends JpaRepository<Employees,Integer>{

	Option [] searchBy = {new Option(0,"전체"), new Option(1,"Bellevue"),
			new Option(2,"Kirkland"), new Option(3,"RedMond"),new Option(4,"Seattle")};

	public List<Employees> findByCityStartsWith(String searchText);
	public List<Employees> findByCity(String c);

	public default List<Employees> findAll(int sb){
		List<Employees> list = null;
		switch(sb) {
		case 0 : list = this.findAll();break;
		case 1 : list = this.findByCity("Bellevue");break;
		case 2 : list = this.findByCity("Kirkland");break;
		case 3 : list = this.findByCity("RedMond");break;
		case 4 : list = this.findByCity("Seattle");break;
		default : list = this.findAll();break;
		}
		return list;
	}
	@Query("select distinct e.city from Employees e")
	public List<Employees> findCites();//도시목록 뽑음.

}
