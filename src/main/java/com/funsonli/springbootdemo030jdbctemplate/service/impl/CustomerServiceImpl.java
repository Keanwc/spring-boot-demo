package com.funsonli.springbootdemo030jdbctemplate.service.impl;

import com.funsonli.springbootdemo030jdbctemplate.dao.CustomerDao;
import com.funsonli.springbootdemo030jdbctemplate.entity.Customer;
import com.funsonli.springbootdemo030jdbctemplate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for
 *
 * @author Funson
 * @date 2019/10/14
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> index() {
        return customerDao.list();
    }

    @Override
    public Integer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerDao.getCustomer(customerId);
    }

    @Override
    public Integer deleteCustomer(String customerId) {
        return customerDao.deleteCustomer(customerId);
    }
}
