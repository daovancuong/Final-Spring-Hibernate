package org.cuong.validator;

import org.cuong.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Component
public class UserValidator implements Validator {
    
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }
    
    public void validate(Object target, Errors errors) {
        Users users = (Users) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.userForm.name");
    }
    
}
