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
public class DaoAutomovel {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsertaCarPU");
        EntityManager em = emf.createEntityManager();
        
        public boolean inserir(automovel a){
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return true;
        }
        
        public boolean editar(automovel a){
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
            return true;
        }
        
        public boolean excluir(automovel a){
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
            return true;   
        }

    public List<automovel> listar() {
        return em.createQuery("select a from automovel a").getResultList();
        
    }
    
}
