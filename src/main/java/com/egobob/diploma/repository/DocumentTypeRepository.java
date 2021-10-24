package com.egobob.diploma.repository;

import com.egobob.diploma.domain.document.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
