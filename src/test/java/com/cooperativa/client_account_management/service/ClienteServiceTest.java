package com.cooperativa.client_account_management.service;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgregarClienteExitoso() {
        ClienteModel cliente = new ClienteModel("000000", "OLGA", LocalDate.of(2023, 1, 1));

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        ClienteModel resultado = clienteService.agregar(cliente);

        assertNotNull(resultado);
        assertEquals(cliente.getNit(), resultado.getNit());
        assertEquals(cliente.getNombre(), resultado.getNombre());
        assertEquals(cliente.getFechaIngreso(), resultado.getFechaIngreso());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testAgregarClienteExcepcion() {
        ClienteModel cliente = new ClienteModel("11111", "DUVAN", LocalDate.of(2023, 1, 1));

        when(clienteRepository.save(cliente)).thenThrow(new RuntimeException("Error al guardar"));

        ClienteModel resultado = clienteService.agregar(cliente);

        assertNull(resultado);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testConsultarClienteExistente() {
        String nit = "123456789";
        ClienteModel cliente = new ClienteModel(nit, "Juan Pérez", LocalDate.of(2023, 1, 1));

        when(clienteRepository.getCliente(nit)).thenReturn(cliente);

        ClienteModel resultado = clienteService.consultar(nit);

        assertNotNull(resultado);
        assertEquals(cliente.getNit(), resultado.getNit());
        verify(clienteRepository, times(1)).getCliente(nit);
    }

    @Test
    public void testConsultarClienteNoExistente() {
        String nit = "987654321";
        when(clienteRepository.getCliente(nit)).thenReturn(null);
        ClienteModel resultado = clienteService.consultar(nit);
        assertNull(resultado);
        verify(clienteRepository, times(1)).getCliente(nit);
    }

    @Test
    public void testConsultarClienteExcepcion() {
        String nit = "123456789";
        when(clienteRepository.getCliente(nit)).thenThrow(new RuntimeException("Error al consultar"));
        ClienteModel resultado = clienteService.consultar(nit);
        assertNull(resultado);
        verify(clienteRepository, times(1)).getCliente(nit);
    }
}
