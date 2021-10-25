package com.egobob.diploma.repository;

import com.egobob.diploma.domain.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByTypeId(Long typeId);

    List<Document> findByProjectId(Long projectId);
}
