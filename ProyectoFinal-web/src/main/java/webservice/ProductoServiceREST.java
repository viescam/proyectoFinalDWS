/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Producto;
import com.fpmislata.service.ProductoServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Vicente
 */
@Path("/ProductoService")
@Stateless
public class ProductoServiceREST {

    @EJB
    private ProductoServiceLocal productoService;
    
    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/Productos")
    public List listProductos() {
        return productoService.listProductos();
    }
    
    
    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/Productos/{id}")
    public Producto findProductoById(@PathParam("id") int id) {
        Producto p = new Producto();
        p.setId(id);
        return productoService.findProductoById(p);
    }
}
