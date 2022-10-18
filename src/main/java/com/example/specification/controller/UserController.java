package com.example.specification.controller;

import com.example.specification.model.Address;
import com.example.specification.model.Operator;
import com.example.specification.model.SearchCriteria;
import com.example.specification.model.User;
import com.example.specification.repository.AddressRepository;
import com.example.specification.repository.UserRepository;
import com.example.specification.specification.UserSpecification;
import com.example.specification.request.UserRequest;
import com.example.specification.specification.UserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<?> getUserByName(@RequestBody UserRequest request) {
        Specification<User> spec1 = new UserSpecification(new SearchCriteria("firstname", Operator.LIKE, request.getFirstname()));
        Specification<User> spec2 = new UserSpecification(new SearchCriteria("lastname", Operator.LIKE, request.getLastname()));

        List<User> users = userRepository.findAll(Specification.where(spec1).and(spec2));

        return ResponseEntity.ok(users);
    }

    @GetMapping("/city")
    public ResponseEntity<?> getUserByAddress(@RequestParam String city) {
        Specification<User> spec = UserSpecifications.getAddress(city);

//        Specification<User> spec = new UserSpecification(new SearchCriteria("city", Operator.LIKE, city));

        List<User> users = userRepository.findAll(spec);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/age")
    public ResponseEntity<?> getUserByAge(@RequestParam int age) {

        Specification<User> spec4 = new UserSpecification(new SearchCriteria("age", Operator.GREATER, age));

        List<User> users = userRepository.findAll(UserSpecifications.getAge(age));
//        List<User> users = userRepository.findAll(spec4);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/address")
    public ResponseEntity<?> getAllAddress(){
        List<Address> addresses = addressRepository.findAll();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserByAgeAndCity(@RequestParam int age, @RequestParam String city,@RequestParam int page){
        Specification<User> specification = Specification.where(UserSpecifications.getAgeAndCity(age, city));
        Page<User> users = userRepository.findAll(specification,PageRequest.of(page,1));
        return ResponseEntity.ok(users);
    }
}
