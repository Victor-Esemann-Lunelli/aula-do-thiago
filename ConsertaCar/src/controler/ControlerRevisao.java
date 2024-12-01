/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.DaoAutomovel;
import model.DaoRevisao;
import model.automovel;
import model.revisao;
import view.FCadrevisao;
import view.FConscliente;
import view.Fconsrevisao;
import view.modelrevisao;

/**
 *
 * @author aluno
 */
public class ControlerRevisao {

    private FCadrevisao fcadrevisao;
    private FConscliente fconscliente;
    private Fconsrevisao fconsrevisao;
    private modelrevisao modelrevisao;
    private DaoRevisao dao;
    private DaoAutomovel daoa;

    public ControlerRevisao() throws ParseException {
        fcadrevisao = new FCadrevisao(null, true);
        fconsrevisao = new Fconsrevisao(null, true);
        modelrevisao = new modelrevisao();
        dao = new DaoRevisao();
        daoa = new DaoAutomovel();
        inicializarcomponentes();
    }

    public void inicializarcomponentes() throws ParseException {
        
        fconsrevisao.TBrevisao.setModel(modelrevisao);

        fcadrevisao.eddata.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

        fcadrevisao.btgravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GravarRevisao();
                } catch (ParseException ex) {
                    Logger.getLogger(ControlerRevisao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        fcadrevisao.btcancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancelar();
            }
        });
        
        
    }

    public void cadastrarrevisao() {
        CarregarAutomoveis();
        fcadrevisao.setVisible(true);
    }

    public void CarregarAutomoveis() {
        fcadrevisao.edauto.removeAllItems();
        for (automovel a : daoa.listar()) {
            fcadrevisao.edauto.addItem(a);
        }
    }
    
    public void Consultarrevisao(){
        CarregarRevioes();
        fconsrevisao.setVisible(true);
    }

    public void CarregarRevioes() {
        modelrevisao.limpar();
        for (revisao r : dao.listar()) {
            modelrevisao.addrevisao(r);
        }
    }
    

    public void GravarRevisao() throws ParseException {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatador.parse(fcadrevisao.eddata.getText());
        double km = Double.parseDouble(fcadrevisao.edkm.getText());
        String servicos = fcadrevisao.edserv.getText();
        automovel auto = (automovel) fcadrevisao.edauto.getSelectedItem();

        revisao r = new revisao(data, km, auto, servicos);
        revisao ultima = dao.selecionar(auto);

        if(ultima != null){
        
        long dataatual = r.getData().getTime() / 86400000;
        long dataultima = ultima.getData().getTime() / 86400000;

        if (r.getKm() - ultima.getKm() > 10000) {
            JOptionPane.showMessageDialog(null, "A revisão está atrasada por quilometragem");
        }

        if (dataatual - dataultima > 365) {
            JOptionPane.showMessageDialog(null, "A revisão está atrasada por tempo");
        }
        
        if (dao.inserir(r)) {
                JOptionPane.showMessageDialog(null, "Gravado!");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }else{
            if (dao.inserir(r)) {
                JOptionPane.showMessageDialog(null, "Gravado!");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "ERRO!");
            }
        }
    }

    public void limpar() {
        fcadrevisao.edauto.setSelectedItem("");
        fcadrevisao.eddata.setText("");
        fcadrevisao.edkm.setText("");
        fcadrevisao.edserv.setText("");
    }

    public void Cancelar() {
        limpar();
        fcadrevisao.setVisible(false);
    }

}
