package ru.cofeok.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cofeok.dbservice.dao.CustomerDAO;
import ru.cofeok.dbservice.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService  {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomer() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }
}
