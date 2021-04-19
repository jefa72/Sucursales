package com.asofte.sucursal.boot;

import com.asofte.sucursal.domain.Sucursal;
import com.asofte.sucursal.repositories.SucursalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDataBase(SucursalRepository sucursalRepository) {
        return args -> {
            Sucursal sucursal1 = new Sucursal("address 1", 0.0, 0.0);
            Sucursal sucursal2 = new Sucursal("address 2", 3.0, 0.0);
            Sucursal sucursal3 = new Sucursal("address 3", 3.0, 4.0);
            log.info("Preloading " + sucursalRepository.save(sucursal1));
            log.info("Preloading " + sucursalRepository.save(sucursal2));
            log.info("Preloading " + sucursalRepository.save(sucursal3));
        };

    }

}
