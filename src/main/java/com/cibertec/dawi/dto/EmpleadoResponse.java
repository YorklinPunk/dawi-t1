package com.cibertec.dawi.dto;

/** Respuesta de salida (schema Empleado del swagger). */
public record EmpleadoResponse(
        Integer id,
        String nombre,
        String apellido,
        String email,
        String especialidad) {
}
