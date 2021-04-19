package com.asofte.sucursal.services;

import com.asofte.sucursal.domain.Sucursal;
import com.asofte.sucursal.exceptions.DuplicatedSucursalException;
import com.asofte.sucursal.repositories.SucursalRepository;
import com.asofte.sucursal.resources.SucursalResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SucursalServiceImplTest {

    @Mock
    private SucursalRepository sucursalRepository;


    @InjectMocks
    private SucursalServiceImpl sucursalService;

    @Test
    void saveSucursal() {
        SucursalResource sucursalResource = new SucursalResource("address XX", 4.5, 5.6);
        Sucursal sucursal = new Sucursal("address XX", 4.5, 5.6);
        when(sucursalRepository.findByDireccion(sucursalResource.getDireccion())).thenReturn(null);
        when(sucursalRepository.save(any())).thenReturn(sucursal);

        Sucursal savedSucursal = sucursalService.saveSucursal(sucursal);

        assertNotNull(savedSucursal);
        assertEquals(sucursalResource.getDireccion(), savedSucursal.getDireccion());

    }

    @Test
    void saveDuplicatedSucursal() {
        SucursalResource sucursalResource = new SucursalResource("address XX", 4.5, 5.6);
        Sucursal sucursal = new Sucursal("address XX", 4.5, 5.6);
        when(sucursalRepository.findByDireccion(sucursalResource.getDireccion())).thenReturn(sucursal);

        assertThrows(DuplicatedSucursalException.class, ()-> sucursalService.saveSucursal(sucursal));

    }

    @Test
    void getSucursal() {
        Sucursal sucursal1 = new Sucursal("address 1", 0.0, 0.0);
        Sucursal sucursal2 = new Sucursal("address 2", 3.0, 0.0);
        Sucursal sucursal3 = new Sucursal("address 3", 3.0, 4.0);

        List<Sucursal> sucursalList = new ArrayList<>();
        sucursalList.add(sucursal1);
        sucursalList.add(sucursal2);
        sucursalList.add(sucursal3);

        Iterable<Sucursal> sucursalIterable = sucursalList;

        when(sucursalRepository.findAll()).thenReturn(sucursalIterable);

        Sucursal sucursal = sucursalService.getSucursal(0.1, 3.1);

        assertEquals(sucursal2.getDireccion(), sucursal.getDireccion());

    }
}