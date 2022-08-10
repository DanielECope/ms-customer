package com.nttdata.mscustomer.controller;

import com.nttdata.mscustomer.entity.Customer;
import com.nttdata.mscustomer.entity.TypeCustomer;
import com.nttdata.mscustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/customer")
public class CustomerController {


    //inyeccion de dependecias

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/find/{id}")
    public Mono<Customer> findById(String id){
        return customerRepository.findById(id);
    }

    @PutMapping
    public Mono<Customer> create(Customer customer) {
        return customerRepository.save(customer);
    }


    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

//
//    @Override
//    public Mono<Customer> update(Customer customer) {
//        return customerRepository.findById(customer.getId())
//                .flatMap(customerExists -> {
//                    return customerRepository.save(customer);
//                })
//                .switchIfEmpty(null);
//    }
//
//    @Override
//    public Mono<Boolean> delete(String id) {
//        return customerRepository.findById(id)
//                .flatMap(
//                        customerExists -> customerRepository.delete(customerExists)
//                                .then(Mono.just(Boolean.TRUE))
//                )
//                .defaultIfEmpty(Boolean.FALSE);
//    }
//
//    @Override
//    public Mono<TypeCustomer> findTypeCustomer(String id) {
//        return null;
//    }

    
    
}

