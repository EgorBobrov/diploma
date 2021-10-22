package com.egobob.diploma.repository;

import com.egobob.diploma.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
