package org.cuong.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
public class NameValidator implements ConstraintValidator<isValidName, String> {
    private String listName;
    
    public void initialize(isValidName constraintAnnotation) {
        this.listName = constraintAnnotation.listName();
    }
    
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name.contains(listName)) {
            return true;
            
        } else {
            return false;
        }
    }
    
}
