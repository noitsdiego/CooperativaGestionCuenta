package com.cooperativa.client_account_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.*;

@Entity
@Table(name = "MOVIMIENTO_CUENTA")
public class MovimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENTE_NIT")
    private String clienteNit;

    @Column(name = "CUENTA")
    private String cuenta;

    @Column(name = "MONTO")
    private double saldo;

    @Column(name = "TIPO_MOVIMIENTO")
    private String tipoMovimiento;

    public MovimientoModel() {
    }

    public MovimientoModel(Long id, String clienteNit, String cuenta, double saldo, String tipoMovimiento) {
        this.id = id;
        this.clienteNit = clienteNit;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.tipoMovimiento = tipoMovimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNit() {
        return clienteNit;
    }

    public void setClienteNit(String clienteNit) {
        this.clienteNit = clienteNit;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}
