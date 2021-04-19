package com.asofte.sucursal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Sucursal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected String direccion;
    protected Double latitud;
    protected Double longitud;

    public Sucursal(){

    }

    public Sucursal(String direccion, Double longitud, Double latitud) {
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

}