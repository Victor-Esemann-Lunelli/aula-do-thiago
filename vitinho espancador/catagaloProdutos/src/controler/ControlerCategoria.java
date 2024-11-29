/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Daocategoria;
import model.categoria;
import view.FCadCategoria;
import view.FCadProduto;
import view.fConsCategoria;
import view.modelCategoria;

/**
 *
 * @author aluno
 */
public class ControlerCategoria {

    private FCadCategoria fCadCategoria;
    private Daocategoria dao;
    private fConsCategoria fConsCategoria;
    private modelCategoria modelCategoria1;
    private categoria categoriaSelecionada;
    private FCadProduto fCadProduto;

    public ControlerCategoria() {
        fCadCategoria = new FCadCategoria(null, true);
        fConsCategoria = new fConsCategoria(null, true);
        dao = new Daocategoria();
        modelCategoria1 = new modelCategoria();
        categoriaSelecionada = null;
        fCadProduto = new FCadProduto(null, true);
        inializarcomponentes();
    }

    public void consultaCategoria() {
        carregarcategorias();
        fConsCategoria.setVisible(true);
    }

    public void carregarcategorias() {
        modelCategoria1.limpar();
        for (categoria c : dao.Listar()) {
            modelCategoria1.addcategoria(c);
        }
    }
    public void cadastrarproduto(){
        fCadProduto.setVisible(true);
    }
    public void cadastrarCategoria() {
        fCadCategoria.setVisible(true);

    }

    public void inializarcomponentes() {

        fConsCategoria.Tbcategorias.setModel(modelCategoria1);
        
        fCadCategoria.BtGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravarCategoria();

            }
        });
        fCadCategoria.BtCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();

            }
        });

        fConsCategoria.BtExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
        fConsCategoria.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
        
    }

    public void editar() {
        int linhaselecionada = fConsCategoria.Tbcategorias.getSelectedRow();
        if (linhaselecionada >= 0) {
            categoriaSelecionada = modelCategoria1.pegar(linhaselecionada);
           fCadCategoria.edNome.setText(categoriaSelecionada.getNome());
           fConsCategoria.setVisible(false);
          fCadCategoria.setVisible(true);
          fConsCategoria.setVisible(true);
        }
        else{
      JOptionPane.showMessageDialog(null, "selicione um registro");
    }
}

    public void excluir() {
        int linhaselecionada = fConsCategoria.Tbcategorias.getSelectedRow();
        if (linhaselecionada >= 0) {
            if (JOptionPane.showConfirmDialog(null, "confirmar a axclusão do registro", "confirmação", 0) == 0) {

                categoria c = modelCategoria1.pegar(linhaselecionada);
                if (dao.excluir(c)) {
                    modelCategoria1.Excluir(linhaselecionada);
                    JOptionPane.showMessageDialog(null, "excluido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "erro");
            }
        }
    }

    public void gravarCategoria() {
        if(categoriaSelecionada == null){
        String nome = fCadCategoria.edNome.getText();
        categoria c = new categoria(nome);
        if (dao.enserir(c)) {
            JOptionPane.showMessageDialog(null, "gravado");
            limpar();
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }
    }else{
            String nome = fCadCategoria.edNome.getText();
            categoriaSelecionada.setNome(nome);
            if(dao.editar(categoriaSelecionada)){
                JOptionPane.showMessageDialog(null, "editado");
                limpar();
                fCadCategoria.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "erro");
                
            }
        }
    }
    public void limpar() {
        categoriaSelecionada = null;
        fCadCategoria.edNome.setText("");
    }

    public void cancelar() {
        limpar();
        fCadCategoria.setVisible(false);
    }

}
