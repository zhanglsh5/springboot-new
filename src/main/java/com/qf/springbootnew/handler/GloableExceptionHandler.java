package com.qf.springbootnew.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.springbootnew.entity.ResultBean;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@ControllerAdvice

public class GloableExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> error = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(error);
        return new ResultBean("failed", json);
    }
}
