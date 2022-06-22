package com.narola.pharmacy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({PharmacyServiceException.class})
    public ModelAndView handlePharmacyServiceException(PharmacyServiceException e)
    {
        ModelAndView modelAndView=new ModelAndView("errorview");
        modelAndView.addObject("errMsg", "From ExceptionHandler,"+e.getMessage());
        return modelAndView;

    }
}
