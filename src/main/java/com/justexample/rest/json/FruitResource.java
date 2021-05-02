package com.justexample.rest.json;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.justexample.entity.Fruit;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

     @GET
    public Collection<Fruit> list() {
        return Fruit.listAll();
    }
  
    @GET
    @Path("/{id}")
    public Fruit get(@PathParam String id) {
        return Fruit.findById(id);
    }

    @POST
    @Transactional
    public Collection<Fruit> add(Fruit fruit) {
        Fruit.persist(fruit);
        return Fruit.listAll();
    }
    
    @PUT
    @Transactional
    public Fruit update(Fruit fruit) {
        Fruit fruitUpdated = Fruit.findById(fruit.id);
        fruitUpdated.name = fruit.name;
        fruitUpdated.description = fruit.description;
        Fruit.persist(fruitUpdated);
        return fruitUpdated;
    }

    @DELETE
    @Transactional
    public void delete(Fruit fruit) {
        fruit.delete();
    }
}