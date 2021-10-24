package com.egobob.diploma.service.document;

import com.egobob.diploma.domain.document.DocumentType;
import com.egobob.diploma.repository.DocumentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public List<?> listAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType getById(Long id) {
        return documentTypeRepository.getById(id);
    }

    @Override
    public DocumentType saveOrUpdate(DocumentType domainObject) {
        return documentTypeRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        documentTypeRepository.deleteById(id);
    }
}
