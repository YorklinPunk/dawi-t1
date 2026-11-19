-- ============================================
-- BASE DE DATOS: bd_empleados
-- ============================================

CREATE DATABASE IF NOT EXISTS bd_empleados;

USE bd_empleados;

-- ============================================
-- TABLA: empleados
-- ============================================

CREATE TABLE IF NOT EXISTS empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    especialidad VARCHAR(100) NULL
);

-- ============================================
-- INSERTAR 10 EMPLEADOS
-- ============================================

INSERT INTO empleados
(nombre, apellido, email, especialidad)
VALUES
('Carlos', 'Mendoza', 'carlos.mendoza@gmail.com', 'Desarrollo Backend'),
('Andrea', 'Ramirez', 'andrea.ramirez@gmail.com', 'Desarrollo Frontend'),
('Luis', 'Fernandez', 'luis.fernandez@gmail.com', 'Base de Datos'),
('Valeria', 'Castillo', 'valeria.castillo@gmail.com', 'Desarrollo Full Stack'),
('Miguel', 'Torres', 'miguel.torres@gmail.com', 'DevOps'),
('Daniela', 'Vargas', 'daniela.vargas@gmail.com', 'QA Testing'),
('Jorge', 'Herrera', 'jorge.herrera@gmail.com', 'Desarrollo Backend'),
('Camila', 'Flores', 'camila.flores@gmail.com', 'Análisis de Sistemas'),
('Ricardo', 'Paredes', 'ricardo.paredes@gmail.com', 'Seguridad Informática'),
('Lucia', 'Navarro', 'lucia.navarro@gmail.com', NULL);
