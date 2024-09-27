package com.cooperativa.client_account_management.repository;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.model.CuentaModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@DataJpaTest
@ActiveProfiles("test")
public class CuentaRepositoryTest {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Test
    public void testGetCuenta() {
        CuentaModel cuenta = new CuentaModel(1L, "111212", "2SSSDA", 500);
        cuentaRepository.save(cuenta);

        CuentaModel result = cuentaRepository.getCuenta("2SSSDA");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(cuenta.getCuenta(), result.getCuenta());
        Assertions.assertEquals(cuenta.getClienteNit(), result.getClienteNit());
        Assertions.assertEquals(cuenta.getSaldo(), result.getSaldo());
    }
}
