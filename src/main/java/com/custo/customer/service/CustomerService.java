package com.custo.customer.service;

import com.custo.customer.dto.CustomerDto;
import com.custo.customer.entity.Customer;
import com.custo.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addData(CustomerDto customerDto){
        Customer customer= new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return customerRepository.save(customer);
    }

    public List<Customer> getData(){
        return customerRepository.findAll();
    }

    public void deleteData(Long id){
        customerRepository.deleteById(id);
    }
public Customer updateData(Long id,CustomerDto customerDto)
{
    Optional<Customer> optionalCustomer=customerRepository.findById(id);
    if (optionalCustomer.isPresent()){
      Customer customer= optionalCustomer.get();
      customer.setName(customerDto.getName());
      customer.setEmail(customerDto.getEmail());
      return customerRepository.save(customer);
    }else
    {
        throw new RuntimeException("Student with id" +id +"not found");
    }
}
}

