package com.egobob.diploma.web.validator;

import com.egobob.diploma.domain.client.Client;
import com.egobob.diploma.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ClientValidator implements Validator {

    private final ClientService clientService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientName", "NotEmpty");
        if (client.getClientName().length() < 6 || client.getClientName().length() > 32) {
            errors.rejectValue("clientName", "Size.userForm.username");
        }
        if (clientService.getByClientName(client.getClientName()) != null) {
            errors.rejectValue("clientName", "Duplicate.clientForm.clientName");
        }

    }
}
