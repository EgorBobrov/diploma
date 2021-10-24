package com.egobob.diploma.service.document;

import com.egobob.diploma.domain.document.DocumentNote;
import com.egobob.diploma.repository.DocumentNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentNoteServiceImpl implements DocumentNoteService {

    private final DocumentNoteRepository noteRepository;

    @Override
    public List<?> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public DocumentNote getById(Long id) {
        return noteRepository.getById(id);
    }

    @Override
    public DocumentNote saveOrUpdate(DocumentNote domainObject) {
        return noteRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<DocumentNote> listAllByDocumentId(Long documentId) {
        return noteRepository.findByDocumentId(documentId);
    }
}
