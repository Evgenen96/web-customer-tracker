package ru.cofeok.customertracker.dbservice.dao;

import ru.cofeok.customertracker.dbservice.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void save(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}

