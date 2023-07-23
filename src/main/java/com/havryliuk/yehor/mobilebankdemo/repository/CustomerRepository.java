package com.havryliuk.yehor.mobilebankdemo.repository;

import com.havryliuk.yehor.mobilebankdemo.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByEmail(String email);
}
