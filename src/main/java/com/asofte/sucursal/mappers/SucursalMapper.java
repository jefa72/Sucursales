package com.asofte.sucursal.mappers;

import com.asofte.sucursal.domain.Sucursal;
import com.asofte.sucursal.resources.SucursalResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalResource sucursalToSucursalResource(Sucursal sucursal);
    Sucursal sucursalResourceToSucursal(SucursalResource sucursalResource);

}
