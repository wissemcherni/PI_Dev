/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pidev.Service;

import java.util.List;

/**
 *
 * @author elaab
 */
public interface IService <T>{
    public void ajouter(T t);
    public void supprimer(T t);
    public void modifier(T t);
    public List<T> Afficher();
   
}
