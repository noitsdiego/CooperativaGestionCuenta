package com.cooperativa.client_account_management.controller;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;


    @PostMapping("/add")
    public ResponseEntity<String> agregarCliente(@RequestBody ClienteModel cliente) {
        ClienteModel clienteNuevo = service.agregar(cliente);
        return new ResponseEntity<>((clienteNuevo != null) ? "Registro Exitoso" : "No se pudo registrar al cliente, por favor, intente de nuevo", HttpStatus.CREATED);
    }

    @GetMapping("/{nit}")
    public ResponseEntity<ClienteModel> consultarCliente(@PathVariable String nit) {
        ClienteModel cliente = service.consultar(nit);
        if(cliente != null){return new ResponseEntity<>(cliente, HttpStatus.OK);}else{return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);}
    }
}
