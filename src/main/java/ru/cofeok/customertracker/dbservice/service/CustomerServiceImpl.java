package ru.cofeok.customertracker.dbservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cofeok.customertracker.dbservice.dao.CustomerDAO;
import ru.cofeok.customertracker.dbservice.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService  {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
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

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }
}
