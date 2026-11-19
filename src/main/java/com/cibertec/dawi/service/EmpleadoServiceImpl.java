package com.cibertec.dawi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cibertec.dawi.dto.EmpleadoRequest;
import com.cibertec.dawi.dto.EmpleadoResponse;
import com.cibertec.dawi.entity.Empleado;
import com.cibertec.dawi.exception.EmpleadoNoEncontradoException;
import com.cibertec.dawi.repository.EmpleadoRepository;

/**
 * Lógica de negocio. No lleva @Service ni @Autowired:
 * se declara como @Bean en AppConfig, que le entrega el repositorio.
 */
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoResponse> listar() {
        return repository.findAll().stream().map(this::aRespuesta).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoResponse buscarPorId(Integer id) {
        return aRespuesta(obtenerOFallar(id));
    }

    @Override
    @Transactional
    public EmpleadoResponse registrar(EmpleadoRequest request) {
        Empleado empleado = new Empleado();
        copiarDatos(request, empleado);
        return aRespuesta(repository.save(empleado));
    }

    @Override
    @Transactional
    public EmpleadoResponse actualizar(Integer id, EmpleadoRequest request) {
        Empleado empleado = obtenerOFallar(id);   // valida que exista
        copiarDatos(request, empleado);
        return aRespuesta(repository.save(empleado));
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        repository.delete(obtenerOFallar(id));    // valida que exista
    }



    private Empleado obtenerOFallar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException(id));
    }

    private void copiarDatos(EmpleadoRequest origen, Empleado destino) {
        destino.setNombre(origen.getNombre().trim());
        destino.setApellido(origen.getApellido().trim());
        destino.setEmail(origen.getEmail().trim());
        destino.setEspecialidad(origen.getEspecialidad());
    }

    private EmpleadoResponse aRespuesta(Empleado e) {
        return new EmpleadoResponse(e.getId(), e.getNombre(), e.getApellido(),
                e.getEmail(), e.getEspecialidad());
    }
}
