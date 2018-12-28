package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Employees;
import net.skhu.model.Option;
import net.skhu.model.Pagination;

public interface EmployeesRepository2 extends JpaRepository<Employees,Integer>{
	Option [] searchBy = {new Option(0,"검색 없음"), new Option(1,"이름"),
			new Option(2,"이메일 주소"), new Option(3,"직책")};

	Option [] orderBy = {new Option(0,"이름 내림차순"), new Option(1,"이름 오름차순"),
			new Option(2,"최신 등록")};

	Sort[] sort = {new Sort(Sort.Direction.DESC,"lastName"),new Sort(Sort.Direction.ASC,"lastName"),
			new Sort(Sort.Direction.DESC,"id")};

	public default List<Employees> findAll(Pagination pagination){
		Pageable pageable =PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
		Page<Employees> page;
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {
		case 0: page = this.findAll(pageable);break;
		case 1: page = this.findByLastName( searchText, pageable); break;
		case 2: page = this.findByEmailAddress( searchText, pageable); break;
		case 3: page = this.findByJobTitle( searchText, pageable); break;
		default: page = this.findAll(pageable); break;
		}
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}
	@Override
	public Page<Employees> findAll(Pageable pageable);
	public Page<Employees> findByLastName(String lastName, Pageable pageable);
	public Page<Employees> findByEmailAddress(String emailAddress, Pageable pageable);
	public Page<Employees> findByJobTitle(String jobTitle, Pageable pageable);
}
