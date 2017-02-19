/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface ClienteServiceLocal {

    List listClientes();

    Cliente findClienteById(Cliente cliente);

    void addCliente(Cliente cliente);

    void updateCliente(Cliente cliente);

    void deleteCliente(Cliente cliente);
    
}
