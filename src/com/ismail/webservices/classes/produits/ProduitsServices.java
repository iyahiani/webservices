package com.ismail.webservices.classes.produits;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/produit")

public class ProduitsServices { 
   
   @GET 
   @Path("/{id}") 
   public Response get(@PathParam("id") long id) {
     Produit produit = Produit.get(id) ; 
     return Response.ok(produit).build();
      
   } 
   
   @POST 
   public Response post(Produit produit) {
      Produit.put(produit) ;
      return Response.ok(produit).build() ;
   }
   
   
  /* @GET 
   
   public Response getAll() {
      List<Produit> produits = Produit.getAll() ; 
      GenericEntity<List<Produit>> entity = new GenericEntity<List<Produit>>(produits) {};
      return Response.ok(entity).build() ;
   } */
}
