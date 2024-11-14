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
public class DaoCliente {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsertaCarPU");
        EntityManager em = emf.createEntityManager();
        
        public boolean inserir(cliente c){
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        }
        
        public List<cliente> listar(){
            return em.createQuery("select c from cliente c").getResultList();
        }
    
}
