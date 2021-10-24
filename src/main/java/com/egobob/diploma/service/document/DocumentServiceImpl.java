package com.egobob.diploma.service.document;

import com.egobob.diploma.domain.document.Document;
import com.egobob.diploma.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public List<?> listAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document getById(Long id) {
        return documentRepository.getById(id);
    }

    @Override
    public Document saveOrUpdate(Document domainObject) {
        return documentRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
