/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.produto;

/**
 *
 * @author aluno
 */
public class modelProduto extends AbstractTableModel {
    
    private List<produto> lista = new ArrayList<>();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0->{
                return "id";
            }
            case 1 ->{
                return "descrição";
            }
            case 2 ->{
                return "valor";
            }
            case 3 ->{
                return "categoria";
            }
    }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        case 0 ->{
        return lista.get(rowIndex).getId_produtos();
    }
        case 1 -> {
        return lista.get(rowIndex).getDescricao();
    }
        case 2 ->{
            return lista.get(rowIndex).getValor();
        }
        case 3 ->{
            return lista.get(rowIndex).getCategoria();
        }
    }
        return "";
    }
    
   
    
    public void addProduto(produto p){
      lista.add(p);
        fireTableRowsUpdated(lista.size()-1, lista.size()-1);
    }
    public void limpar(){
        lista.clear();
    }
    public produto pegar(int indice){
        return lista.get(indice);
    }
    public void Excluir(int indice){
        lista.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
}
