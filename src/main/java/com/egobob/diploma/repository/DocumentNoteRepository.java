package com.egobob.diploma.repository;

import com.egobob.diploma.domain.document.DocumentNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentNoteRepository extends JpaRepository<DocumentNote, Long> {
}
