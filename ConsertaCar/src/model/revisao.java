/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "revisao")
public class revisao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data;
    private double km;
    @ManyToOne
    @JoinColumn(name = "id_automovel")
    private automovel automovel;
    private String servicos_realizados;

    public revisao() {
    }

    public revisao(Date data, double km, automovel automovel, String servicos_realizados) {
        this.data = data;
        this.km = km;
        this.automovel = automovel;
        this.servicos_realizados = servicos_realizados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public automovel getId_automovel() {
        return automovel;
    }

    public void setId_automovel(automovel automovel) {
        this.automovel = automovel;
    }

    public String getServicos_realizados() {
        return servicos_realizados;
    }

    public void setServicos_realizados(String servicos_realizados) {
        this.servicos_realizados = servicos_realizados;
    }
    
    @Override
    public String toString() {
        return "revisao{" + "id=" + id + ", data=" + data + ", km=" + km + ", id_automovel=" + automovel + '}';
    }
   
}

