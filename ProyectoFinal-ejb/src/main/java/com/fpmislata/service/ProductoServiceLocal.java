/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface ProductoServiceLocal {

    List listProductos();

    void addProducto(Producto producto);

    Producto findProductoById(Producto producto);

    void updateProducto(Producto producto);

    void deleteProducto(Producto producto);
    
}
