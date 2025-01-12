package com.custo.customer.controller;

import com.custo.customer.dto.CustomerDto;
import com.custo.customer.entity.Customer;
import com.custo.customer.service.CustomerService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/coustomerAdd")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addData (@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.addData(customerDto),CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getData(){
        List<Customer> list =customerService.getData();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable  Long id){
         customerService.deleteData(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateData(@PathVariable Long id,@RequestBody CustomerDto customerDto){
        Customer updateData=customerService.updateData(id,customerDto);
        return ResponseEntity.ok(updateData);
    }
}
