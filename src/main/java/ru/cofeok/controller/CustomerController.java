package ru.cofeok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cofeok.dbservice.dao.CustomerDAO;
import ru.cofeok.dbservice.entity.Customer;
import ru.cofeok.dbservice.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject the customer dao
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get the customers from dao
        List<Customer> theCustomers = customerService.getCustomers();
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using the customer service
        customerService.save(theCustomer);

        return "redirect:/customer/list"; // todo why redirect here??
    }
}
