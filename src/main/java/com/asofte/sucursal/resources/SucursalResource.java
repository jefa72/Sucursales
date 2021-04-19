package com.asofte.sucursal.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SucursalResource {

    private String direccion;
    private Double latitud;
    private Double longitud;

}
