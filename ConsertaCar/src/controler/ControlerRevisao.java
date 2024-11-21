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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.DaoAutomovel;
import model.DaoRevisao;
import view.FCadrevisao;

/**
 *
 * @author aluno
 */
public class ControlerRevisao {
    
    private FCadrevisao fcadrevisao;
    private DaoRevisao dao;
    private DaoAutomovel daoa;

    public ControlerRevisao() throws ParseException {
        fcadrevisao = new FCadrevisao(null, true);
        dao = new DaoRevisao();
        daoa = new DaoAutomovel();
        inicializarcomponentes();
    }

    public void inicializarcomponentes() throws ParseException {
        
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
    
    public void cadastrarrevisao(){
       fcadrevisao.setVisible(true);
    }
    
    public void GravarRevisao() throws ParseException{
       SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");        
       Date data = formatador.parse(fcadrevisao.eddata.getText());
    }
    
    public void limpar(){
        fcadrevisao.edauto.setSelectedItem("");
        fcadrevisao.eddata.setText("");
        fcadrevisao.edkm.setText("");
        fcadrevisao.edserv.setText("");
    }
    
    public void Cancelar(){
        limpar();
        fcadrevisao.setVisible(false);
    }
    
}
