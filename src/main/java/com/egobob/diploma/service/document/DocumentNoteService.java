package com.egobob.diploma.service.document;

import com.egobob.diploma.domain.document.DocumentNote;
import com.egobob.diploma.service.BaseCrudService;

import java.util.List;

public interface DocumentNoteService extends BaseCrudService<DocumentNote> {
    List<DocumentNote> listAllByDocumentId(Long documentId);
}
