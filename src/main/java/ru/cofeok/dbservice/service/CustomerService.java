package ru.cofeok.dbservice.service;

import ru.cofeok.dbservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    void save(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
