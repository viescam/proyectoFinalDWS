/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Cliente;
import com.fpmislata.service.ClienteServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Vicente
 */
@Path("/ClienteService")
@Stateless
public class ClienteServiceREST {

    @EJB
    private ClienteServiceLocal clienteService;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/Clientes")
    public List<Cliente> listClientes() {
        return clienteService.listClientes();
    }

   
    @GET
    @Produces("application/json;charset=UTF-8")
    @Path("/Clientes/findClienteById/{id}")
    public Cliente findClienteById(@PathParam("id") int id) {
        Cliente c = new Cliente();
        c.setId(id);
        return clienteService.findClienteById(c);
        
    }
    
    @POST
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Clientes/add")
    public Response addCliente(Cliente cliente) {
        try{
            clienteService.addCliente(cliente);
            return Response.ok().entity(cliente).build();
        }catch(Exception ex){
            ex.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
                
        }
    }
    
    @PUT
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Clientes/update/{id}")
    public Response updatePersona(@PathParam("id") int id, Cliente clienteModificado) {
        try{
            Cliente c = new Cliente();
            c.setId(id);
            c = clienteService.findClienteById(c);
            if(c!=null){
                c.setNombre(clienteModificado.getNombre());
                c.setApellidos(clienteModificado.getApellidos());
                c.setNif(clienteModificado.getNif());
                c.setDireccion(clienteModificado.getDireccion());
                c.setPoblacion(clienteModificado.getPoblacion());
                c.setProvincia(clienteModificado.getProvincia());
                c.setCodigopostal(clienteModificado.getCodigopostal());
                c.setTelefono(clienteModificado.getTelefono());
                clienteService.updateCliente(c);
                return Response.ok().entity(c).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
            }else{
                return Response.status(Status.NOT_FOUND).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
            }            
        }catch(Exception ex){
            ex.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();                
        }
    }
    
    @DELETE
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Clientes/delete/{id}")
    public Response deleteCliente(@PathParam("id") int id) {
        try {
            Cliente cliente = new Cliente();
            cliente.setId(id);
            clienteService.deleteCliente(cliente);
            return Response.ok().entity(cliente).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")).build();
        }
    }
    
    
    
    
    
    
}
