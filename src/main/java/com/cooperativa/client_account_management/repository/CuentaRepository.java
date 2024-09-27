package com.cooperativa.client_account_management.repository;

import com.cooperativa.client_account_management.model.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CuentaRepository extends JpaRepository<CuentaModel, Long> {

    @Query(value = "SELECT * FROM CUENTA WHERE CUENTA = ?",
            nativeQuery = true)
    public CuentaModel getCuenta(String cuenta);


}
