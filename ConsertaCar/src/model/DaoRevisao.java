/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class DaoRevisao {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsertaCarPU");
    EntityManager em = emf.createEntityManager();
    
    public revisao selecionar(automovel automovel){
        Query consulta = em.createQuery("select r from revisao r where r.automovel=:q order by r.id desc");
        consulta.setParameter("q",automovel );
        consulta.setMaxResults(1);
        return (revisao)consulta.getSingleResult();
    }
    
    public boolean inserir(revisao r){
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        return true;
    }
}
