package com.egobob.diploma.web.validator;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ProjectValidator implements Validator {

    private final ProjectService projectService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = (Project) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (project.getName().length() < 6 || project.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.username");
        }
        if (projectService.getByName(project.getName()) != null) {
            errors.rejectValue("name", "Duplicate.projectForm.projectName");
        }
    }
}
