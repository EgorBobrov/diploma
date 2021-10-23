package com.egobob.diploma.service.project;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<?> listAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getById(id);
    }

    @Override
    public Project saveOrUpdate(Project domainObject) {
        return projectRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<?> listAllByClientId(Long clientId) {
        return projectRepository.findByClientId(clientId);
    }
}
