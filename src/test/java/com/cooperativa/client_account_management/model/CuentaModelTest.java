package com.cooperativa.client_account_management.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaModelTest {

    @Test
    public void testClienteModelConstructorAndGetters() {
        Long id = 100L;
        String clienteNit = "1002551222";
        String numCuenta = "325685544255";
        double saldo = 555000000;

        CuentaModel cuenta = new CuentaModel(id, clienteNit, numCuenta, saldo);

        assertEquals(clienteNit, cuenta.getClienteNit());
        assertEquals(numCuenta, cuenta.getCuenta());
        assertEquals(saldo, cuenta.getSaldo());
    }

    @Test
    public void testSetters() {
        CuentaModel cuenta = new CuentaModel();

        Long id = 100L;
        String clienteNit = "1002551222";
        String numCuenta = "325685544255";
        double saldo = 555000000;

        cuenta.setId(id);
        cuenta.setClienteNit(clienteNit);
        cuenta.setCuenta(numCuenta);
        cuenta.setSaldo(saldo);

        assertEquals(clienteNit, cuenta.getClienteNit());
        assertEquals(numCuenta, cuenta.getCuenta());
        assertEquals(saldo, cuenta.getSaldo());
    }
}
