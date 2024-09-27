package com.cooperativa.client_account_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CUENTA")
public class CuentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLIENTE_NIT")
    private String clienteNit;


    @Column(name = "CUENTA")
    private String cuenta;

    @Column(name = "SALDO_INICIAL")
    private double saldo;

    public CuentaModel() {
    }

    public CuentaModel(Long id, String clienteNit, String cuenta, double saldo) {
        this.id = id;
        this.clienteNit = clienteNit;
        this.cuenta = cuenta;
        this.saldo = saldo;
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
}