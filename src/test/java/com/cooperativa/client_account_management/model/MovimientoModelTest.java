package com.cooperativa.client_account_management.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoModelTest {

    @Test
    public void testClienteModelConstructorAndGetters() {
        Long id = 5L;
        String clienteNit = "1002551222";
        String numCuenta = "325685544255";
        double monto = 555000000;
        String tipoMov = "DB";

        MovimientoModel mov = new MovimientoModel(id, clienteNit, numCuenta, monto, tipoMov);

        assertEquals(clienteNit, mov.getClienteNit());
        assertEquals(numCuenta, mov.getCuenta());
        assertEquals(monto, mov.getSaldo());
        assertEquals(tipoMov, mov.getTipoMovimiento());
    }

    @Test
    public void testSetters() {
        MovimientoModel mov = new MovimientoModel();

        Long id = 5L;
        String clienteNit = "1002551222";
        String numCuenta = "325685544255";
        double monto = 555000000;
        String tipoMov = "CR";


        mov.setId(id);
        mov.setClienteNit(clienteNit);
        mov.setCuenta(numCuenta);
        mov.setSaldo(monto);
        mov.setTipoMovimiento(tipoMov);

        assertEquals(id, mov.getId());
        assertEquals(clienteNit, mov.getClienteNit());
        assertEquals(numCuenta, mov.getCuenta());
        assertEquals(monto, mov.getSaldo());
        assertEquals(tipoMov, mov.getTipoMovimiento());
    }
}
