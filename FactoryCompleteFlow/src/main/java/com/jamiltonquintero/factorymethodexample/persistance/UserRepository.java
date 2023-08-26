package com.jamiltonquintero.factorymethodexample.persistance;

import com.jamiltonquintero.factorymethodexample.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
