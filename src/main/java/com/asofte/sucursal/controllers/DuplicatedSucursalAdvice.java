package com.asofte.sucursal.controllers;

import com.asofte.sucursal.exceptions.DuplicatedSucursalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DuplicatedSucursalAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicatedSucursalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String duplicatedSucursalHandler(DuplicatedSucursalException e) {
        return e.getMessage();
    }

}
