package com.cooperativa.client_account_management.service;

import com.cooperativa.client_account_management.repository.ClienteRepository;
import com.cooperativa.client_account_management.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository repository;
}
