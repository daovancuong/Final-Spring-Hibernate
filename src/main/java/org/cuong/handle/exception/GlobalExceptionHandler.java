package org.cuong.handle.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = NullPointerException.class)
//    public String handleNullPointerEX(Exception exception) {
//        System.out.println(exception.toString());
//        return "nullpointer_exception";
//        
//    }
    
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handle500EX(Exception exception) {
//        System.out.println(exception.toString());
//        return "exception_500";
//        
//    }
//    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
//    @ExceptionHandler(IOException.class)
//    public void handleIOException(){
//        System.out.println("----------------------------------------");
////        logger.error("IOException handler executed");
//        //returning 404 error code
//    }
}
