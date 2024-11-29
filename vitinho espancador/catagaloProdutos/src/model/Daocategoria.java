/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author aluno
 */
public class Daocategoria {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("catagaloProdutosPU");
    EntityManager em = emf.createEntityManager();
    
    public boolean enserir(categoria c){
       em.getTransaction().begin();
       em.persist(c);
       em.getTransaction().commit();
       return true;
    }
    public List<categoria> Listar(){
        return em.createQuery("select c from categoria c").getResultList();
    }
    public boolean excluir(categoria c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        return true;
        
    }
     public boolean editar(categoria c){
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        return true;
        
    }
}
