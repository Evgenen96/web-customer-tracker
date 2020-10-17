package ru.cofeok.dbservice.service;

import ru.cofeok.dbservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void save(Customer theCustomer);
}
