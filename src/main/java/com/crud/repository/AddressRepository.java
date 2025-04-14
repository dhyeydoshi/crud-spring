package com.crud.repository;

import com.crud.model.UserModel;
import com.crud.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findByUserAccountNumber(String accountNumber);
}
