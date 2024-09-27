package com.cooperativa.client_account_management.model;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteModelTest {

    @Test
    public void testClienteModelConstructorAndGetters() {
        String nit = "1002551222";
        String nombre = "DUVAN";
        LocalDate fechaIngreso = LocalDate.of(1999, 4, 3);
        ClienteModel cliente = new ClienteModel(nit, nombre, fechaIngreso);
        assertEquals(nit, cliente.getNit());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(fechaIngreso, cliente.getFechaIngreso());
    }

    @Test
    public void testSetters() {
        ClienteModel cliente = new ClienteModel();

        String nit = "987654321";
        String nombre = "María Gómez";
        LocalDate fechaIngreso = LocalDate.of(2023, 2, 1);

        cliente.setNit(nit);
        cliente.setNombre(nombre);
        cliente.setFechaIngreso(fechaIngreso);

        assertEquals(nit, cliente.getNit());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(fechaIngreso, cliente.getFechaIngreso());
    }
}
