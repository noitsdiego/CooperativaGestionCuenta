package com.cooperativa.client_account_management.service;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.model.CuentaModel;
import com.cooperativa.client_account_management.model.MovimientoModel;
import com.cooperativa.client_account_management.repository.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CuentaServiceTest {

    @InjectMocks
    private CuentaService cuentaService;

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgregarCuentaClienteExistenteYCuentaNoExistente() {
        CuentaModel cuenta = new CuentaModel();
        cuenta.setCuenta("123456");
        cuenta.setClienteNit("123456789");
        when(clienteService.consultar(cuenta.getClienteNit())).thenReturn(new ClienteModel());
        when(cuentaRepository.getCuenta(cuenta.getCuenta())).thenReturn(null);
        String resultado = cuentaService.agregar(cuenta);
        assertEquals("Cuenta Creada Exitosamente", resultado);
        verify(cuentaRepository, times(1)).save(cuenta);
    }

    @Test
    public void testAgregarCuentaClienteNoExistente() {
        CuentaModel cuenta = new CuentaModel();
        cuenta.setClienteNit("987654321");
        when(clienteService.consultar(cuenta.getClienteNit())).thenReturn(null);
        String resultado = cuentaService.agregar(cuenta);
        assertEquals("El cliente no existe en el sistema, verique.", resultado);
        verify(cuentaRepository, never()).save(cuenta);
    }

    @Test
    public void testRealizarMovimientoDebitoExitoso() {
        MovimientoModel movimiento = new MovimientoModel();
        movimiento.setCuenta("123456");
        movimiento.setClienteNit("123456789");
        movimiento.setTipoMovimiento("DB");
        movimiento.setSaldo(100.0);

        CuentaModel cuenta = new CuentaModel();
        cuenta.setSaldo(200.0);
        cuenta.setCuenta("123456");

        when(clienteService.consultar(movimiento.getClienteNit())).thenReturn(new ClienteModel());
        when(cuentaRepository.getCuenta(movimiento.getCuenta())).thenReturn(cuenta);

        String resultado = cuentaService.realizarMovimiento(movimiento);

        assertEquals("Movimiento de Debito Exitoso", resultado);
        assertEquals(100.0, cuenta.getSaldo());
        verify(cuentaRepository, times(1)).save(cuenta);
    }

}
