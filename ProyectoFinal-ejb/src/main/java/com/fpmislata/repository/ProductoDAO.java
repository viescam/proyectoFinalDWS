/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vicente
 */
@Stateless
public class ProductoDAO implements ProductoDAOLocal {
    
    @PersistenceContext(unitName = "proyectofinalPU")
    EntityManager em;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listProductos() {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public void addProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return em.find(Producto.class, producto.getId());
    }

    @Override
    public void updateProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        producto = findProductoById(producto);
        em.remove(producto);
    }  
    
    
    
    
}
