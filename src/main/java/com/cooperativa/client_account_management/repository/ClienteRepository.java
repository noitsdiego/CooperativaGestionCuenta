package com.cooperativa.client_account_management.repository;

import com.cooperativa.client_account_management.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, String> {

}
