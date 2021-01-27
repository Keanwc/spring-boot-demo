package com.funsonli.springbootdemo030jdbctemplate.service;

import com.funsonli.springbootdemo030jdbctemplate.entity.Customer;

import java.util.List;

/**
 * Class for
 *
 * @author Funson
 * @date 2019/10/14
 */
public interface CustomerService {
    List<Customer> index();
    Integer createCustomer(Customer customer);
    Integer updateCustomer(Customer customer);
    Customer getCustomer(String customerId);
    Integer deleteCustomer(String customerId);
}