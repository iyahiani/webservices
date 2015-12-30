package com.ismail.webservices.personne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO {

   public List<Personne> getAllPersonnes() {
     
      List<Personne> PersonneList = null;
      try {
         File file = new File("Personnes.dat");
         if (!file.exists()) {
            Personne Personne = new Personne(1, "Mahesh", 30);
            PersonneList = new ArrayList<Personne>();
            PersonneList.add(Personne);
            PersonneList.add(new Personne(2, "yahiani", 32));
            PersonneList.add(new Personne(3, "aliane", 25));
            PersonneList.add(new Personne(4, "Laterem", 28));
            PersonneList.add(new Personne(5, "Kevin", 21));
            PersonneList.add(new Personne(6, "Xavier", 42));
            PersonneList.add(new Personne(7, "Dieu", 100000000));
            savePersonneList(PersonneList);
         } else {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            PersonneList = (List<Personne>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      return PersonneList;
   }

   private void savePersonneList(List<Personne> personneList) {
      try {
         File file = new File("Personnes.dat");
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(personneList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public Personne getPersonne(long id) {

      List<Personne> personnes = this.getAllPersonnes();
      for (Personne personne : personnes) {
         if (personne.getId() == id)
            return personne;
      }

      return null;
   }

   public Personne getPersonne(String nom) {

      List<Personne> personnes = this.getAllPersonnes();
      for (Personne personne : personnes) {
         if (personne.getNom().equalsIgnoreCase(nom)) 
            return personne;
      }

      return null;
   } 
   
   public void addPersonne(Personne p) {
      File file = new File("Personnes.dat");
      FileInputStream fis;
      try {
         fis = new FileInputStream(file); 
         ObjectInputStream ois = new ObjectInputStream(fis);
         List<Personne> PersonneList = (List<Personne>) ois.readObject(); 
          PersonneList.add(p); 
         this.savePersonneList(PersonneList);
      } catch (IOException | ClassNotFoundException e) {
         
         e.printStackTrace();
      }
      
   } 
   
   public int updatePersonne(Personne p) {
   
      List<Personne> listPersonne = this.getAllPersonnes() ;  
      for (Personne personne : listPersonne) { 
         if(personne.getId() == p.getId()) {
            int index = listPersonne.indexOf(personne) ; 
            listPersonne.set(index, p) ; 
            this.savePersonneList(listPersonne); 
            return 1 ;
         } 
      } 
      return 0 ;
   } 
    
   public int deletePersonne(long id) {
      List<Personne> listPersonne = this.getAllPersonnes() ;
      for (Personne personne : listPersonne) {
         if (personne.getId() == id) {
            listPersonne.remove(personne) ; 
            this.savePersonneList(listPersonne);
            return 1 ;
         }
      }  
      return 0 ;
      
   }
      
}
