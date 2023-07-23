package com.havryliuk.yehor.mobilebankdemo.config;

import com.havryliuk.yehor.mobilebankdemo.model.entity.Customer;
import com.havryliuk.yehor.mobilebankdemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankUserDetailsManager implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName;
        String password;
        List<GrantedAuthority> authorities;
        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user: " + username);
        } else {
            var customer = customers.get(0);
            userName = customer.getEmail();
            password = customer.getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        }

        return new User(userName, password, authorities);
    }
}
