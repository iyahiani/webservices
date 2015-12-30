package com.ismail.webservices.personne;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="personne")
public class Personne implements Serializable{

   private static final long serialVersionUID = 1L; 
   private int id ; 
   private String nom ; 
   private int age ; 
   
   public Personne() {} 
   public Personne(int id , String nom , int age) {
      this.id = id ; 
      this.nom = nom ;
      this.age = age ;
   }
   public int getId() {
      return id;
   } 
   
   @XmlElement
   public void setId(int id) {
      this.id = id;
   }
   public String getNom() {
      return nom;
   } 
   @XmlElement
   public void setNom(String nom) {
      this.nom = nom;
   }
   public int getAge() {
      return age;
   } 
   @XmlElement
   public void setAge(int age) {
      this.age = age;
   }
}
