package com.fortebank.forteidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import java.util.TimeZone;

@SpringBootApplication
public class ForteideaApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(ForteideaApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	private void testJpaMethods(){
//		Customer customer = new Customer();
//		customer.setUsername("MKuzhaniyazova");
//		customer.setEmployeeId("235GY");
//
//		customerService.createCustomer(customer);
//
//		customerService.findAll().forEach(it-> System.out.println(it));
//
//		customerService.findAll().forEach(it-> System.out.println(it));
//		System.out.println(customer.getId());
//	}
}
