/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vicente
 */
@Stateless
public class CategoriaDAO implements CategoriaDAOLocal {
    
    @PersistenceContext(unitName = "proyectofinalPU")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listCategorias() {
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }

    @Override
    public void addCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public Categoria findCategoriaById(Categoria categoria) {
        return em.find(Categoria.class,categoria.getId());
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        em.merge(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoria = findCategoriaById(categoria);
        em.remove(categoria);
    }
    
    
    
    
    
    
}
