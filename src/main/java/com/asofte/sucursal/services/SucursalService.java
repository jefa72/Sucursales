package com.asofte.sucursal.services;

import com.asofte.sucursal.domain.Sucursal;
import com.asofte.sucursal.resources.SucursalResource;

import java.util.List;

public interface SucursalService {

    public Sucursal saveSucursal(Sucursal sucursal);
    public List<Sucursal> getSucursales();
    public Sucursal getSucursal(Double latitud, Double longitud);

}
