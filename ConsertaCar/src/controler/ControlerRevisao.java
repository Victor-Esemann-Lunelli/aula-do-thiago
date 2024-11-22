/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

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

    public ControlerRevisao() {
        fcadrevisao = new FCadrevisao(null, true);
        dao = new DaoRevisao();
        daoa = new DaoAutomovel();
        inicializarcomponentes();
    }

    public void inicializarcomponentes() {
        
    }
    
    public void cadastrarrevisao(){
       fcadrevisao.setVisible(true);
    }
}
