package ru.cofeok.customertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cofeok.customertracker.dbservice.entity.Customer;
import ru.cofeok.customertracker.dbservice.service.CustomerService;

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

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);
        // set the customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);
        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String showFormDelete(@RequestParam("customerId") int theId) {

        // delete the customer
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
