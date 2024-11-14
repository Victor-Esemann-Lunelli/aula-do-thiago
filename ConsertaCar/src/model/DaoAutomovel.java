/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
    
}
