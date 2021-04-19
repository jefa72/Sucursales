package com.asofte.sucursal.exceptions;

public class DuplicatedSucursalException extends RuntimeException{

    public DuplicatedSucursalException() {
        super("Sucursal already exists");
    }

}
