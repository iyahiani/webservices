package com.ismail.webservices.classes.produits;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.research.ws.wadl.Link;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Produit implements IProduit  {

   protected long id ; 
   protected String nom ; 
   protected int prix ; 
   protected List<Link> liens  ; 
   
   
   public Produit getProduct(long id) {
      
      return null;
   }

   public static Produit get(long id) {
      return null;
     
   }

   public static void put(Produit produit) {
   }

   public static List<Produit> getAll() {
      
      return null;
   }
}
