package com.cibertec.dawi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cibertec.dawi.repository.EmpleadoRepository;
import com.cibertec.dawi.service.EmpleadoService;
import com.cibertec.dawi.service.EmpleadoServiceImpl;

/**
 * Configuración explícita de beans: aquí se arma la cadena
 * repository -> service, en un solo lugar y sin @Autowired.
 */
@Configuration
public class AppConfig {

    @Bean
    public EmpleadoService empleadoService(EmpleadoRepository repository) {
        return new EmpleadoServiceImpl(repository);
    }
}
