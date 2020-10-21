package ru.cofeok.customertracker.dbservice.service;

import ru.cofeok.customertracker.dbservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    void save(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
