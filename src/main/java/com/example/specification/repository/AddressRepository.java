package com.example.specification.repository;

import com.example.specification.model.Address;
import com.example.specification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address,String> , JpaSpecificationExecutor<Address> {
}
