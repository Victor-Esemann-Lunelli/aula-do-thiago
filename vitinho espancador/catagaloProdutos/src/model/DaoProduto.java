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
public class DaoProduto {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("catagaloProdutosPU");
EntityManager em = emf.createEntityManager(); 

 public boolean enserir(produto p){
       em.getTransaction().begin();
       em.persist(p);
       em.getTransaction().commit();
       return true;
    }
    public List<produto> Listar(){
        return em.createQuery("select p from produto p").getResultList();
    }
    public boolean excluir(produto p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        return true;
        
    }
     public boolean editar(produto p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        return true;
        
    }
}

