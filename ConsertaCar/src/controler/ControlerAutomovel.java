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
import view.FConsautomovel;
import view.modelautomovel;

/**
 *
 * @author aluno
 */
public class ControlerAutomovel {

    private FCadautomovel fcadauto;
    private FConsautomovel fconsautomovel;
    private automovel automovelselecionado;
    private modelautomovel modelautomovel;
    private DaoAutomovel dao;
    private DaoCliente daoc;

    public ControlerAutomovel() {
        fcadauto = new FCadautomovel(null, true);
        fconsautomovel = new FConsautomovel(null, true);
        modelautomovel = new modelautomovel();
        automovelselecionado = null;
        dao = new DaoAutomovel();
        daoc = new DaoCliente();
        inicializarcomponentes();
    }

    public void ConsultarAutomoveis() {
        CarregarAutomoveis();
        fconsautomovel.setVisible(true);
    }

    public void CarregarAutomoveis() {
        modelautomovel.limpar();
        for (automovel a : dao.listar()) {
            modelautomovel.addAutomovel(a);
        }
    }

    public void inicializarcomponentes() {

        fconsautomovel.TBautomovel.setModel(modelautomovel);

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
        fconsautomovel.bteditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
        fconsautomovel.btexcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    public void GravarAutomovel() {
        
        if(fcadauto.edano.getText().isEmpty() ||
           fcadauto.edmarca.getText().isEmpty() ||
           fcadauto.edmodelo.getText().isEmpty() ||
           fcadauto.edplaca.getText().isEmpty() ||
           fcadauto.edcliente.getSelectedItem() == null
           ){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }
        
        if (automovelselecionado == null) {
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
        } else {
            String placa = fcadauto.edplaca.getText();
            automovelselecionado.setPlaca(placa);
            String marca = fcadauto.edmarca.getText();
            automovelselecionado.setMarca(marca);
            String modelo = fcadauto.edmodelo.getText();
            automovelselecionado.setModelo(modelo);
            int ano = Integer.parseInt(fcadauto.edano.getText());
            automovelselecionado.setAno(ano);
            cliente cliente = (cliente) fcadauto.edcliente.getSelectedItem();
            automovelselecionado.setCliente(cliente);

            if (dao.editar(automovelselecionado)) {
                JOptionPane.showMessageDialog(null, "Editado!");
                limpar();
                fcadauto.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "ERRO):");
            }
        }
    }

    public void editar() {
        int linhaselecionada = fconsautomovel.TBautomovel.getSelectedRow();
        if (linhaselecionada >= 0) {
            automovelselecionado = modelautomovel.pegar(linhaselecionada);
            fcadauto.edano.setText(Integer.toString(automovelselecionado.getAno()));
            fcadauto.edmarca.setText(automovelselecionado.getMarca());
            fcadauto.edmodelo.setText(automovelselecionado.getModelo());
            fcadauto.edplaca.setText(automovelselecionado.getPlaca());

            CarregarClientes();
            cliente clienteAtual = automovelselecionado.getCliente();
            fcadauto.edcliente.setSelectedItem(clienteAtual);

            fconsautomovel.setVisible(false);
            fcadauto.setVisible(true);
            fcadauto.setVisible(false);
            fconsautomovel.setVisible(true);
        }
    }

    public void excluir() {
        int linhaselecionada = fconsautomovel.TBautomovel.getSelectedRow();
        if (linhaselecionada >= 0) {
            if (JOptionPane.showConfirmDialog(null, "confirma a axclusão do registro?", "confirmação", 0) == 0) {
                automovel a = modelautomovel.pegar(linhaselecionada);

                if (dao.excluir(a)) {
                    modelautomovel.Excluir(linhaselecionada);
                    JOptionPane.showMessageDialog(null, "Excluído!");
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO!");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
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
