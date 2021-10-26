package com.egobob.diploma.web.validator;

import com.egobob.diploma.domain.document.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class DocumentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Document.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Document document = (Document) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        if (document.getTitle().length() < 6 || document.getTitle().length() > 32) {
            errors.rejectValue("title", "Size.userForm.username");
        }
    }
}
