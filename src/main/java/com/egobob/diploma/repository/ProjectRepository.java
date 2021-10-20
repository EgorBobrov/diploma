package com.egobob.diploma.repository;

import com.egobob.diploma.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
