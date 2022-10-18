package com.example.specification.specification;

import com.example.specification.model.Address;
import com.example.specification.model.Address_;
import com.example.specification.model.User;
import com.example.specification.model.User_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserSpecifications {

    public static Specification<User> getAddress(String city) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(User_.ADDRESS).get(Address_.CITY),"%"+city+"%");
        };
    }

    public static Specification<User> getAge(int age){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(User_.AGE),age);
        };
    }

    public static Specification<User> getAgeAndCity(int age, String city){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            list.add(criteriaBuilder.greaterThanOrEqualTo(root.get(User_.AGE), age));
            list.add(criteriaBuilder.like(root.get(User_.ADDRESS).get(Address_.CITY), city));
            Predicate[] predicate = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(predicate));
        };
    }
}
