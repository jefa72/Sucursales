package com.asofte.sucursal.controllers;

import com.asofte.sucursal.mappers.SucursalMapper;
import com.asofte.sucursal.resources.SucursalResource;
import com.asofte.sucursal.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sucursales")
@AllArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;
    private final SucursalMapper sucursalMapper;

    @PostMapping
    SucursalResource saveSucursal(@RequestBody SucursalResource sucursalResource) {
        return sucursalMapper.sucursalToSucursalResource(sucursalService.saveSucursal(sucursalMapper.sucursalResourceToSucursal(sucursalResource)));
    }

    @GetMapping
    List<SucursalResource> getAllSucursales() {
        return sucursalService.getSucursales().stream().map(s -> sucursalMapper.sucursalToSucursalResource(s)).collect(Collectors.toList());

    }

    @GetMapping("/ubic")
    SucursalResource getSucursal(@RequestParam("latitud") Double latitud, @RequestParam("longitud") Double longitud) {

        return sucursalMapper.sucursalToSucursalResource(sucursalService.getSucursal(latitud, longitud));

    }


}
