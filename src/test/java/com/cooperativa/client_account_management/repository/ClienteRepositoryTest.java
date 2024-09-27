package com.cooperativa.client_account_management.repository;

import com.cooperativa.client_account_management.model.ClienteModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@DataJpaTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testGetCliente() {
        ClienteModel cliente = new ClienteModel("123456789", "Juan Pérez", LocalDate.of(2023, 1, 1));
        clienteRepository.save(cliente);

        ClienteModel result = clienteRepository.getCliente("123456789");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(cliente.getNit(), result.getNit());
        Assertions.assertEquals(cliente.getNombre(), result.getNombre());
        Assertions.assertEquals(cliente.getFechaIngreso(), result.getFechaIngreso());
    }
}
