package com.cooperativa.client_account_management.repository;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.model.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, String> {

    @Query(value = "SELECT * FROM CLIENTE WHERE NIT = ?",
            nativeQuery = true)
    public ClienteModel getCliente(String nit);

}
