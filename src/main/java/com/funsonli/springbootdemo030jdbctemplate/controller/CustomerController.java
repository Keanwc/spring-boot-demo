package com.funsonli.springbootdemo030jdbctemplate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.funsonli.springbootdemo030jdbctemplate.entity.Customer;
import com.funsonli.springbootdemo030jdbctemplate.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Customer Controller
 *
 * @author Funson
 * @date 2019/10/12
 */

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  // @GetMapping({ "", "/", "index" })
  // public String index() {
  //   ObjectMapper objectMapper = new ObjectMapper();

  //   String carAsString = "";

  //   try {
  //     carAsString = objectMapper.writeValueAsString(customerService.index());
  //   } catch (Exception ex) {}

  //   return carAsString;
  // }

  @PostMapping("/")
  public String createCustomer(@RequestBody Customer customer) {

    int res = 0;

    if(customer.getCustomerID()==null || (customer.getCustomerID()!=null && customer.getCustomerID()==0)){
      res = customerService.createCustomer(customer);
    }else{
      res = customerService.updateCustomer(customer);
    }

    
    return String.valueOf(res);
  }

  @DeleteMapping("/{customerID}")
  public String deleteCustomer(@PathVariable String customerID) {

    int res = customerService.deleteCustomer(customerID);
   
    return String.valueOf(res);
  }

  @GetMapping("/{customerID}")
  public String getCustomer(@PathVariable String customerID) {
    ObjectMapper objectMapper = new ObjectMapper();
    String result = "";

    if (customerID.isBlank() || customerID.isBlank()) {
      try {
        result = objectMapper.writeValueAsString(customerService.index());
      } catch (Exception ex) {}
    } else {
      try {
        Customer customer = customerService.getCustomer(customerID);

        result = objectMapper.writeValueAsString(customer);
      } catch (Exception ex) {}
    }

    return String.valueOf(result);
  }



  //   @GetMapping("/add/{name}")
  //   public String add(HttpServletRequest request, @PathVariable String name) {
  //     Customer model = new Customer();
  //     model.setContactName(name);

  //     int res = customerService.save(model);
  //     return String.valueOf(res);
  //   }

}
