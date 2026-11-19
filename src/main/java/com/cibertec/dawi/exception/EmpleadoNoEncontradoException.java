package com.cibertec.dawi.exception;

public class EmpleadoNoEncontradoException extends RuntimeException {

    public EmpleadoNoEncontradoException(Integer id) {
        super("Empleado no encontrado con id: " + id);
    }
}
