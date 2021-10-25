package com.egobob.diploma.service.document;

import com.egobob.diploma.domain.document.Document;
import com.egobob.diploma.service.BaseCrudService;

import java.util.List;

public interface DocumentService extends BaseCrudService<Document> {
    List<?> listAllByDoctypeId(Long typeId);

    List<?> listAllByProjectId(Long projectId);
}
