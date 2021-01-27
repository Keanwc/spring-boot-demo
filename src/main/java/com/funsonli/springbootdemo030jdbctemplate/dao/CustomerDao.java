package com.funsonli.springbootdemo030jdbctemplate.dao;

import com.funsonli.springbootdemo030jdbctemplate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class for
 *
 * @author Funson
 * @date 2019/10/14
 */
@Repository
public class CustomerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> list() {
        List<Customer> list = jdbcTemplate.query("select * from Customers", new Object[]{}, new BeanPropertyRowMapper(Customer.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    public Customer getCustomer(String customerId) {
        return (Customer)jdbcTemplate.queryForObject("select * from Customers where CustomerID = ? ", new BeanPropertyRowMapper(Customer.class), new Object[]{customerId});
    }

    public int createCustomer(Customer customer) {
        return jdbcTemplate.update("insert into Customers(ContactName) values(?)", customer.getContactName());
    }

    public int updateCustomer(Customer customer) {
        return jdbcTemplate.update("update Customers set ContactName = ? where CustomerID = ? ", new Object[]{customer.getContactName(), customer.getCustomerID() } );
    }

    public int deleteCustomer(String customerId) {
        return jdbcTemplate.update("delete from Customers where CustomerID = ? ", new Object[]{customerId});
    }


}
