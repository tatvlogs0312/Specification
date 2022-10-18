package com.example.specification.metamodel;

import com.example.specification.model.Address;
import com.example.specification.model.User;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class Users_ {
    private static volatile SingularAttribute<User,String> firstname;
    private static volatile SingularAttribute<User,String> lastname;
    private static volatile SingularAttribute<User,String> email;
    private static volatile SingularAttribute<User,Integer> age;
    private static volatile SingularAttribute<User, Address> address;

    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String EMAIL = "email";
    private static final String AGE = "age";
    private static final String ADDRESS = "address";
}
