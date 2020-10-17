package ru.cofeok.dbservice.dao;

import ru.cofeok.dbservice.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void save(Customer theCustomer);

    Customer getCustomer(int theId);
}

