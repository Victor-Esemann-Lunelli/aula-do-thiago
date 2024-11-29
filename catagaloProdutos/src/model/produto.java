/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
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
@Table(name = "produtos")
public class produto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idprodutos; 
@ManyToOne
@JoinColumn(name = "id_categoria")
private categoria categoria;
private String descricao;
private double valor;

    public produto() {
    }

    public produto(categoria categoria, String descricao, double valor) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId_produtos() {
        return idprodutos;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setId_produtos(int id_produtos) {
        this.idprodutos = id_produtos;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "produto{" + "idprodutos=" + idprodutos + ", categoria=" + categoria + ", descricao=" + descricao + ", valor=" + valor + '}';
    }


}
