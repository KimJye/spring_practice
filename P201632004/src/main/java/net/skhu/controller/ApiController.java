package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Customers;
import net.skhu.domain.Employees;
import net.skhu.domain.OrderDetails;
import net.skhu.domain.Orders;
import net.skhu.domain.Products;
import net.skhu.repository.CustomersRepository;
import net.skhu.repository.EmployeesRepository;
import net.skhu.repository.OrderDetailRepository;
import net.skhu.repository.OrdersRepository;
import net.skhu.repository.ProductsRepository;

@RestController
@RequestMapping("api")
public class ApiController {
	 @Autowired EmployeesRepository employeeRepository;
	 @Autowired OrderDetailRepository orderDetailRepository;
	 @Autowired ProductsRepository productRepository;
	 @Autowired CustomersRepository customerRepository;
	 @Autowired OrdersRepository ordersRepository;

	 @RequestMapping("employees")
	 public List<Employees> employees() {
		 return employeeRepository.findAll();
	}
	 /*
	 @RequestMapping("order/{id}/products")
	 public List<Products> orders(@PathVariable("id") int id) {
		OrderDetails detail = orderDetailRepository.findById(id).get();
		return detail.getListProducts();
	}
	*/

	 @RequestMapping("products")
	 public List<Products> products() {
		 return productRepository.findAll();
	}

	 @RequestMapping("customer/{id}/orderDate")
	 public List<Orders> orderDate(@PathVariable("id") int id) {
		 Customers customer = customerRepository.findById(id).get();
		 return customer.getOrders();
	}

	 @RequestMapping("customer/{id}/products")
	 public List<Products> products(@PathVariable("id") int id) {
		 Customers customer =  customerRepository.findById(id).get();

		 List<Products> list = new ArrayList<Products>();

		 for(Orders o : customer.getOrders()) {
			 for(OrderDetails d : o.getOrderDetails())
				 list.add(d.getProducts());
		 }
		 return list;
	}

}
