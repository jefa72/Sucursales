package com.asofte.sucursal.services;

import com.asofte.sucursal.domain.Sucursal;
import com.asofte.sucursal.exceptions.DuplicatedSucursalException;
import com.asofte.sucursal.mappers.SucursalMapper;
import com.asofte.sucursal.repositories.SucursalRepository;
import com.asofte.sucursal.resources.SucursalResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal saveSucursal(Sucursal sucursal) {
        if(sucursalRepository.findByDireccion(sucursal.getDireccion()) != null) {
            log.info("Tried to create duplicated branch");
            throw new DuplicatedSucursalException();
        }else {
            return sucursalRepository.save(sucursal);
        }

    }

    @Override
    public List<Sucursal> getSucursales() {
        List<Sucursal> sucursalList = new ArrayList<>();
        Iterable<Sucursal> iterableSucursales = sucursalRepository.findAll();
        iterableSucursales.forEach(s -> sucursalList.add(s));
        return sucursalList;
    }

    @Override
    public Sucursal getSucursal(Double longitud, Double latitud) {
        List<Sucursal> sucursalList = new ArrayList<>();
        Iterable<Sucursal> iterableSucursales = sucursalRepository.findAll();
        iterableSucursales.forEach(s -> sucursalList.add(s));

        Optional<Pair<Double, Sucursal>> minSucursal = sucursalList.stream().map(s -> {
            return new Pair<Double, Sucursal>(distanceToSucursal(longitud, latitud, s.getLongitud(), s.getLatitud()), s);
        }).peek(System.out::println).min((o1, o2) -> {return Double.compare(o1.getValue0(), o2.getValue0());});

        return minSucursal.orElse(null).getValue1();
    }

    private Double distanceToSucursal(Double longitud1, Double latitud1, Double longitud2, Double latitud2) {
        return Math.sqrt(Math.pow(latitud2 - latitud1, 2) + Math.pow(longitud2 - longitud1, 2));
    }

}

