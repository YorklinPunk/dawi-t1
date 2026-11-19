package com.cibertec.dawi.service;

import java.util.List;

import com.cibertec.dawi.dto.EmpleadoRequest;
import com.cibertec.dawi.dto.EmpleadoResponse;

public interface EmpleadoService {

    List<EmpleadoResponse> listar();

    EmpleadoResponse buscarPorId(Integer id);

    EmpleadoResponse registrar(EmpleadoRequest request);

    EmpleadoResponse actualizar(Integer id, EmpleadoRequest request);

    void eliminar(Integer id);
}
