package com.egobob.diploma.repository;

import com.egobob.diploma.domain.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
