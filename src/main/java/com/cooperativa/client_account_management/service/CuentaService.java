package com.cooperativa.client_account_management.service;

import com.cooperativa.client_account_management.model.ClienteModel;
import com.cooperativa.client_account_management.model.CuentaModel;
import com.cooperativa.client_account_management.model.MovimientoModel;
import com.cooperativa.client_account_management.repository.ClienteRepository;
import com.cooperativa.client_account_management.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository repository;

    @Autowired
    ClienteService clienteService;


    @Transactional
    public String agregar(CuentaModel cuenta){
        if(clienteService.consultar(cuenta.getClienteNit()) != null){
                if(consultar(cuenta.getCuenta()) == null){
                    repository.save(cuenta);
                    return "Cuenta Creada Exitosamente";
                }else{
                    return "El numero de cuenta ya se encuentra registrado.";
                }
        }else{
            return "El cliente no existe en el sistema, verique.";
        }
    }

    public CuentaModel consultar(String numCuenta) {
        CuentaModel cuenta = repository.getCuenta(numCuenta);
        if(cuenta!=null){return cuenta;}else{return null;}
    }

    @Transactional
    public String realizarMovimiento(MovimientoModel movimiento){
        String respuesta = "";
        if(clienteService.consultar(movimiento.getClienteNit()) != null){
            CuentaModel cuenta = consultar(movimiento.getCuenta());
            if(cuenta != null){
                double saldoActual = cuenta.getSaldo();
                if(movimiento.getTipoMovimiento().equals("DB")){
                    if(saldoActual>movimiento.getSaldo()){
                        cuenta.setSaldo(saldoActual - movimiento.getSaldo());
                        respuesta = "Movimiento de Debito Exitoso";
                    }else{
                        respuesta = "Fondos Insuficientes.";
                    }
                }else{
                    cuenta.setSaldo(saldoActual + movimiento.getSaldo());
                    respuesta = "Movimiento de Credito Exitoso.";
                }
                repository.save(cuenta);
            }else{
                respuesta = "El numero de cuenta no se encuentra registrado.";
            }
        }else{
            respuesta = "El cliente no existe en el sistema, verique.";
        }
        return respuesta;
    }


}
