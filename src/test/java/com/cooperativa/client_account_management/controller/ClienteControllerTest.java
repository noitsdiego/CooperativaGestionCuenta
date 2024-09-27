package com.cooperativa.client_account_management.controller;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void testAgregarClienteExitoso() throws Exception {
        ClienteModel cliente = new ClienteModel("123456789", "Juan Pérez", LocalDate.of(2023, 1, 1));

        when(clienteService.agregar(any(ClienteModel.class))).thenReturn(cliente);

        mockMvc.perform(post("/api/cliente/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nit\":\"123456789\", \"nombre\":\"Juan Pérez\", \"fechaIngreso\":\"2023-01-01\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Registro Exitoso"));

        verify(clienteService, times(1)).agregar(any(ClienteModel.class));
    }

    @Test
    public void testAgregarClienteFallo() throws Exception {
        ClienteModel cliente = new ClienteModel("987654321", "María Gómez", LocalDate.of(2023, 1, 1));

        when(clienteService.agregar(any(ClienteModel.class))).thenReturn(null);

        mockMvc.perform(post("/api/cliente/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nit\":\"987654321\", \"nombre\":\"María Gómez\", \"fechaIngreso\":\"2023-01-01\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("No se pudo registrar al cliente, por favor, intente de nuevo"));

        verify(clienteService, times(1)).agregar(any(ClienteModel.class));
    }

    @Test
    public void testConsultarClienteExistente() throws Exception {
        String nit = "123456789";
        ClienteModel cliente = new ClienteModel(nit, "Juan Pérez", LocalDate.of(2023, 1, 1));

        when(clienteService.consultar(nit)).thenReturn(cliente);

        mockMvc.perform(get("/api/cliente/{nit}", nit)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(clienteService, times(1)).consultar(nit);
    }

    @Test
    public void testConsultarClienteNoExistente() throws Exception {
        String nit = "987654321";

        when(clienteService.consultar(nit)).thenReturn(null);

        mockMvc.perform(get("/api/cliente/{nit}", nit)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(clienteService, times(1)).consultar(nit);
    }
}
