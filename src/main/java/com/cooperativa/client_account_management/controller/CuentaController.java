package com.cooperativa.client_account_management.controller;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.model.CuentaModel;
import com.cooperativa.client_account_management.model.MovimientoModel;
import com.cooperativa.client_account_management.service.ClienteService;
import com.cooperativa.client_account_management.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

    @Autowired
    CuentaService service;


    @PostMapping("/add")
    public ResponseEntity<String> agregarCliente(@RequestBody CuentaModel cuenta) {
        return new ResponseEntity<>( service.agregar(cuenta), HttpStatus.OK);
    }

    @PostMapping("/movimiento")
    public ResponseEntity<String> realizarMovimiento(@RequestBody MovimientoModel movimientoModel) {
        return new ResponseEntity<>( service.realizarMovimiento(movimientoModel), HttpStatus.OK);
    }

}
