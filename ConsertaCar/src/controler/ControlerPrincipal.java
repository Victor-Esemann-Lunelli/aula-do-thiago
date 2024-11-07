/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import view.Fprincipal;

/**
 *
 * @author aluno
 */
public class ControlerPrincipal {
    private Fprincipal fprincipal;

    public ControlerPrincipal() {
        fprincipal = new Fprincipal();
        inicializarComponentes();
    }
    
    public void executar(){
        fprincipal.setVisible(true);
    }
    
    public void inicializarComponentes(){
        
    }
  
}
