/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import view.Fprincipal;

/**
 *
 * @author aluno
 */
public class ControlerPrincipal {

    private Fprincipal fprincipal;
    private ControlerCliente controlcliente;
    private ControlerAutomovel controlauto;
    private ControlerRevisao controlrevisao;

    public ControlerPrincipal() throws ParseException {
        fprincipal = new Fprincipal();
        controlcliente = new ControlerCliente();
        controlauto = new ControlerAutomovel();
        controlrevisao = new ControlerRevisao();
        inicializarComponentes();
    }

    public void executar() {
        fprincipal.setVisible(true);
    }

    public void inicializarComponentes() {
        fprincipal.micliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelacadcliente();
            }
        });
        fprincipal.miautomovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelacadautomovel();
            }
        });
        fprincipal.mirevisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelacadrevisao();
            }
        });
        fprincipal.miclientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelaconscliente();
            }
        });
        fprincipal.miautomoveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelaconsautomovel();
            }
        });
        fprincipal.mirevisoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirtelaconsrevisao();
            }
        });
    }

    public void abrirtelacadcliente() {
        controlcliente.cadastrarcliente();
    }

    public void abrirtelacadautomovel() {
        controlauto.cadastrarauto();
    }

    public void abrirtelacadrevisao() {
        controlrevisao.cadastrarrevisao();
    }

    public void abrirtelaconscliente() {
        controlcliente.ConsultarCliente();
    }
    
    public void abrirtelaconsautomovel(){
        controlauto.ConsultarAutomoveis();
    }
    
    public void abrirtelaconsrevisao(){
        controlrevisao.Consultarrevisao();
    }

}
