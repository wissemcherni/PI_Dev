/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
  import java.util.List;
/**
 *
 * @author Maha Maatoug
 */
public interface IService<T> {
  


    
    public void ajouter(T e);
    public void modifier(T e);
    public void supprimer(T e);
    public List<T> afficher();
}


