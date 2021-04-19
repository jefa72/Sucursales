package com.asofte.sucursal.repositories;

import com.asofte.sucursal.domain.Sucursal;
import org.springframework.data.repository.CrudRepository;

public interface SucursalRepository extends CrudRepository<Sucursal, Integer> {

    Sucursal findByDireccion(String direccion);
}
