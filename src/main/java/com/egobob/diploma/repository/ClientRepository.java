package com.egobob.diploma.repository;

import com.egobob.diploma.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
