/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author user
 */
public interface IService<T> {
    
    public void ajouter(T p);
    public void modifier(T p);
    public void supprimer(String p);
    public List<T> afficher();
    public T rechercher(String p);
}


