package com.egobob.diploma.service.project;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.service.BaseCrudService;

import java.util.List;

public interface ProjectService extends BaseCrudService<Project> {
    List<?> listAllByClientId(Long clientId);
}
