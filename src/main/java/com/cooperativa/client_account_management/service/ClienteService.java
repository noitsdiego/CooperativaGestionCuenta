package com.cooperativa.client_account_management.service;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;


}
