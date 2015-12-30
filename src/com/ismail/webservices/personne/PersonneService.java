package com.ismail.webservices.personne;

import java.io.IOException;
import java.util.List;
import com.ismail.webservices.personne.PersonneDAO;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personneService")
public class PersonneService {

   
   PersonneDAO dao = new PersonneDAO() ;
   String succes ="<Result>Succes UPDATE</Result>" ; 
   String error = "<Result>erreur UPDATE</Result>";
   
   @GET
   @Path("/personne")
   @Produces(MediaType.APPLICATION_XML)
   public List<Personne> getAll() {
      return dao.getAllPersonnes();
   }

   @GET
   @Path("/{id}")
   public Response get(@PathParam("id") long id) {

      Personne personne = dao.getPersonne(id);
      return Response.ok(personne).build();
   }


   
   @PUT 
   @Path ("/personnes") 
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updatePersonne(@FormParam("id") int id,
         @FormParam("nom") String nom , 
         @FormParam("age") int age, @Context HttpServletResponse servletResponse) throws IOException  { 
      
      Personne p = new Personne(10, "bou3a", 55) ;
      int rslt = dao.updatePersonne(p); 
      if (rslt == 1 ) return succes ; 
      return  error ;
   }
      @DELETE 
      @Path ("/personne") 
      @Produces(MediaType.APPLICATION_XML) 
      public String delete(@PathParam("id") long id) {
         int rslt  = dao.deletePersonne(id) ; 
         if (rslt == 1 ) return succes ;
         return error ;
      }
}
