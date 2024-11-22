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
    
    public revisao selecionar(revisao id_automovel){
        Query consulta = em.createQuery("select r from revisao r where id_automovel=:q order by id desc limit 1");
        consulta.setParameter("q",id_automovel );
        return (revisao)consulta.getSingleResult();
    }
}
