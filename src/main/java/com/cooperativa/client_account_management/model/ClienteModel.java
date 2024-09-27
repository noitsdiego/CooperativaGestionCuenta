package com.cooperativa.client_account_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel {


    @Id
    @Column(name = "NIT")
    private String nit;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_DE_INGRESO") // Nombre de la columna en PostgreSQL
    private LocalDate fechaIngreso;

    public ClienteModel() {
    }

    public ClienteModel(String nit, String nombre, LocalDate fechaIngreso) {
        this.nit = nit;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
