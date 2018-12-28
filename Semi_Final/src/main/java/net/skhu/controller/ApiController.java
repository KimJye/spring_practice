package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Customers;
import net.skhu.domain.Employees;
import net.skhu.domain.Invoices;
import net.skhu.domain.OrderDetails;
import net.skhu.domain.Products;
import net.skhu.repository.CustomersRepository;
import net.skhu.repository.EmployeesRepository;
import net.skhu.repository.OrderDetailRepository;
import net.skhu.repository.OrdersRepository;

@RestController
@RequestMapping("api")
public class ApiController {
	 @Autowired EmployeesRepository employeeRepository;
	 @Autowired OrdersRepository ordersRepository;
	 @Autowired OrderDetailRepository orderDetailRepository;
	 @Autowired CustomersRepository customersRepository;

	 @RequestMapping("employees")
	 public List<Employees> employees() {
		 return employeeRepository.findAll();
	}
	 @RequestMapping("order/{id}/products")
	 public List<Products> products(@PathVariable("id") int id) {
		 List<OrderDetails> detail = ordersRepository.findById(id).get().getOrderDetails();
		 List<Products> list = new ArrayList<Products>();

		 for(OrderDetails o : detail)
			 list.add(o.getProducts());
		 return list;
	}

	 @RequestMapping("order/{id}/invoices")
	 public Invoices invoices(@PathVariable("id") int id) {

		 Invoices invoices = ordersRepository.findById(id).get().getInvoices();

		 return invoices;

	 }

	 @RequestMapping("customers")
	 public List<Customers> customers() {
		 return customersRepository.findAll();
	}


}
