/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Fprincipal;

/**
 *
 * @author aluno
 */
public class controlerPrincipal {
  private Fprincipal fprincipal;  
  private ControlerCategoria controlerCategoria;
  private controlerProduto conProduto;
  

    public controlerPrincipal() {
        this.fprincipal = new Fprincipal();
        controlerCategoria = new ControlerCategoria();
        conProduto = new controlerProduto();
        inicializarconponetes();
    }
   public void executar(){
       fprincipal.setVisible(true);
   }
  public void inicializarconponetes(){
      fprincipal.miCadCategoria.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             abrirTelaCadastrarCategoria();
          }
      });
     fprincipal.miConsCategoria.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            abrirtelaConsCategoria();
          }
     });
     fprincipal.miCadProduto.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              abrirtelacadstroProduto();
          }
     });
     
      fprincipal.miConsProduto.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              abrirtelaConsProduto();
          }
          
      });
  }
  public void abrirTelaCadastrarCategoria(){
    controlerCategoria.cadastrarCategoria();
}
public void abrirtelaConsCategoria(){
    controlerCategoria.consultaCategoria();
}
public void abrirtelacadstroProduto(){
    conProduto.cadastrarProduto();
}
 public void abrirtelaConsProduto(){
     conProduto.consultarProduto();
 }
}
