package com.cooperativa.client_account_management.controller;

import com.cooperativa.client_account_management.model.CuentaModel;
import com.cooperativa.client_account_management.model.MovimientoModel;
import com.cooperativa.client_account_management.service.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class CuentaControllerTest {

    @InjectMocks
    private CuentaController cuentaController;

    @Mock
    private CuentaService cuentaService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
    }

    @Test
    public void testAgregarClienteExitoso() throws Exception {
        CuentaModel cuenta = new CuentaModel();
        cuenta.setCuenta("123456");
        cuenta.setClienteNit("123456789");

        when(cuentaService.agregar(any(CuentaModel.class))).thenReturn("Cuenta Creada Exitosamente");

        mockMvc.perform(post("/api/cuenta/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cuenta\":\"123456\", \"clienteNit\":\"123456789\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cuenta Creada Exitosamente"));

        verify(cuentaService, times(1)).agregar(any(CuentaModel.class));
    }

    @Test
    public void testRealizarMovimientoExitoso() throws Exception {
        MovimientoModel movimiento = new MovimientoModel();
        movimiento.setCuenta("123456");
        movimiento.setClienteNit("123456789");
        movimiento.setTipoMovimiento("DB");
        movimiento.setSaldo(100.0);

        when(cuentaService.realizarMovimiento(any(MovimientoModel.class))).thenReturn("Movimiento de Debito Exitoso");

        mockMvc.perform(post("/api/cuenta/movimiento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cuenta\":\"123456\", \"clienteNit\":\"123456789\", \"tipoMovimiento\":\"DB\", \"saldo\":100.0}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Movimiento de Debito Exitoso"));

        verify(cuentaService, times(1)).realizarMovimiento(any(MovimientoModel.class));
    }
}
