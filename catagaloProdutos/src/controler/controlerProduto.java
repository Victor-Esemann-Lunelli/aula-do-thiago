/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DaoProduto;
import model.Daocategoria;
import model.categoria;
import model.produto;
import view.FCadProduto;
import view.fConsProduto;
import view.modelProduto;

/**
 *
 * @author aluno
 */
public class controlerProduto {

    private Daocategoria daocategoria;
    private FCadProduto fCadProduto;
    private Daocategoria dao;
    private produto Produto;
    private DaoProduto daoProduto;
    private modelProduto ModelProduto;
    private fConsProduto fConsProduto;
    private produto Produroselecionado;
    private categoria categoria;
    
    
    public controlerProduto() {
        dao = new Daocategoria();
        daocategoria = new Daocategoria();
        fCadProduto = new FCadProduto(null, true);
        produto p = new produto();
        daoProduto = new DaoProduto();
        ModelProduto = new modelProduto();
        fConsProduto = new fConsProduto(null, true);
        Produroselecionado = null;
        categoria = new categoria();
        inicializarconponentes();
    }
    
    public void inicializarconponentes() {
        fConsProduto.TbProdutos.setModel(ModelProduto);
        
        fCadProduto.BtGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarnoBnaco();
            }
        });
        fCadProduto.BtCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        fConsProduto.BtEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
    }
    
    public void consultarProduto(){
        carregarProduto();
        fConsProduto.setVisible(true);
    }
    
    public void carregarProduto(){
        ModelProduto.limpar();
        for(produto p : daoProduto.Listar()){
            ModelProduto.addProduto(p);
        }
    }
    
    public void cadastrarProduto() {
        carregarCategorias();
        fCadProduto.setVisible(true);
    }
    
    public void carregarCategorias() {
        fCadProduto.edCategoria.removeAllItems();
        for (categoria c : daocategoria.Listar()) {
            fCadProduto.edCategoria.addItem(c);
        }
        
    }

    public void cadastrarnoBnaco() {
        String descricao = fCadProduto.edDescricao.getText();
        categoria cat = (categoria) fCadProduto.edCategoria.getSelectedItem();
        double valor = Double.parseDouble(fCadProduto.edValor.getText());
        produto p = new produto(cat, descricao,valor);
        if (daoProduto.enserir(p)) {
            JOptionPane.showMessageDialog(null, "gravado");
        } else {
            JOptionPane.showMessageDialog(null, "erro");
        }
    }
    
    public void editar(){
        
        int linhaselecionada = fConsProduto.TbProdutos.getSelectedRow();
        if(linhaselecionada >= 0){
        Produroselecionado = ModelProduto.pegar(linhaselecionada);
        fCadProduto.edDescricao.setText(Produroselecionado.getDescricao());
        fCadProduto.edValor.setText(Double.toString(Produroselecionado.getValor()));
        fCadProduto.edCategoria.setSelectedItem(categoria);
        fConsProduto.setVisible(false);
        fCadProduto.setVisible(true);
        
        }
        else{
            JOptionPane.showConfirmDialog(null,"selecione um registro");
        }
    }
    
    public void limpar(){
        fCadProduto.edDescricao.setText("");
        fCadProduto.edValor.setText("");
    }
    public void cancelar(){
        limpar();
        fCadProduto.setVisible(false);
    }
}
