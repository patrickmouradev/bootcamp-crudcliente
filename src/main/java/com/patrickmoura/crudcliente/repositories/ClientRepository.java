package com.patrickmoura.crudcliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrickmoura.crudcliente.entities.Client;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{

}
