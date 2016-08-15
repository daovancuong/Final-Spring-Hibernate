package org.cuong.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface isValidName {
    String listName() default "cuong";
    
    String message() default "Please provide valid name like cuong,tung,thanh";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
}
