/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DaoAutomovel;
import model.DaoCliente;
import model.automovel;
import model.cliente;
import view.FCadautomovel;

/**
 *
 * @author aluno
 */
public class ControlerAutomovel {

    private FCadautomovel fcadauto;
    private DaoAutomovel dao;
    private DaoCliente daoc;

    public ControlerAutomovel() {
        fcadauto = new FCadautomovel(null, true);
        dao = new DaoAutomovel();
        daoc = new DaoCliente();
        inicializarcomponentes();
    }

    public void inicializarcomponentes() {
        fcadauto.btgravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GravarAutomovel();
            }
        });
        fcadauto.btcancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancelar();
            }
        });
    }

    public void GravarAutomovel() {
        String placa = fcadauto.edplaca.getText();
        String marca = fcadauto.edmarca.getText();
        String modelo = fcadauto.edmodelo.getText();
        int ano = Integer.parseInt(fcadauto.edano.getText());
        cliente cliente = (cliente) fcadauto.edcliente.getSelectedItem();
        automovel a = new automovel(placa, marca, modelo, ano, cliente);

        if (dao.inserir(a)) {
            JOptionPane.showMessageDialog(null, "Gravado!");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO):");
            limpar();
        }

    }

    public void cadastrarauto() {
        CarregarClientes();
        fcadauto.setVisible(true);
    }

    public void CarregarClientes() {
        fcadauto.edcliente.removeAllItems();
        for (cliente c : daoc.listar()) {
            fcadauto.edcliente.addItem(c);
        }
    }

    public void Cancelar() {
        limpar();
        fcadauto.setVisible(false);
    }

    public void limpar() {
        fcadauto.edano.setText("");
        fcadauto.edmarca.setText("");
        fcadauto.edmodelo.setText("");
        fcadauto.edplaca.setText("");
    }

}
