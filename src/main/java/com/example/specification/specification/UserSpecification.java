package com.example.specification.specification;

import com.example.specification.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UserSpecification implements Specification<User> {

    private SearchCriteria criteria;


    @Override
    public Specification<User> and(Specification<User> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<User> or(Specification<User> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        try {
            Join<Address, User> userAddress = root.join(User_.ADDRESS);
            if (criteria.getOperation() == Operator.GREATER) {
                return builder.greaterThanOrEqualTo(userAddress.get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation() == Operator.LESS) {
                return builder.lessThanOrEqualTo(userAddress.get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation() == Operator.LIKE) {
                return builder.like(userAddress.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else if (criteria.getOperation() == Operator.EQUAL) {
                return builder.equal(userAddress.get(criteria.getKey()), criteria.getValue());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }
}
