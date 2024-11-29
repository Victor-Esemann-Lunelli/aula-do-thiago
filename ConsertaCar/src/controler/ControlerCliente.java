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
import model.DaoCliente;
import model.cliente;
import view.FCadcliente;

/**
 *
 * @author aluno
 */
public class ControlerCliente {
    private FCadcliente fcadcliente;
    private DaoCliente daoc;

    public ControlerCliente() throws ParseException{
        fcadcliente = new FCadcliente(null, true);
        daoc = new DaoCliente();
        inicializarcomponentes();
    }
    
    public void inicializarcomponentes() throws ParseException{
        
        fcadcliente.eddatanasc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        
        fcadcliente.btgravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GravarCliente();
                } catch (ParseException ex) {
                    Logger.getLogger(ControlerCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        fcadcliente.btcancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancelar();
            }
        });
    }
    
    public void GravarCliente() throws ParseException{
        String nome = fcadcliente.ednome.getText();
        String cpf = fcadcliente.edcpf.getText();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");        
        Date data = formatador.parse(fcadcliente.eddatanasc.getText());
        String telefone = fcadcliente.edtelefone.getText();
        cliente c = new cliente(cpf, nome, data, telefone);
        
        if(daoc.inserir(c)){
            JOptionPane.showMessageDialog(null,"Gravado!");
            limpar();
        }else{
            JOptionPane.showMessageDialog(null, "ERRO):");
            limpar();
        }
    }
    
    public void limpar(){
        fcadcliente.edcpf.setText("");
        fcadcliente.eddatanasc.setText("");
        fcadcliente.ednome.setText("");
        fcadcliente.edtelefone.setText("");
    }
    
    public void cadastrarcliente(){
        fcadcliente.setVisible(true);
    }
    
    public void Cancelar(){
        limpar();
        fcadcliente.setVisible(false);
    }
}
