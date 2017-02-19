/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vicente
 */
@Stateless
public class ClienteDAO implements ClienteDAOLocal {
    
    @PersistenceContext(unitName = "proyectofinalPU")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listClientes() {
        List<Cliente> lista = em.createNamedQuery("Cliente.findAll").getResultList();
        return lista;
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        cliente = em.find(Cliente.class, cliente.getId());
        return cliente;
    }

    @Override
    public void addCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        cliente = findClienteById(cliente);
        em.remove(cliente);
    }
    
    
    
    
    
    
    
    
}
