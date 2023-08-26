package com.jamiltonquintero.factorymethodexample.persistance;

import com.jamiltonquintero.factorymethodexample.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
