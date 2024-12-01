/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.cliente;

/**
 *
 * @author Notebook
 */
public class modelcliente extends AbstractTableModel{
    
    private List<cliente> lista = new ArrayList<>();

    @Override
    public int getRowCount() {
        return lista.size();    
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

   @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "id";
            }
            case 1 -> {
                return "nome";
            }
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     switch(columnIndex){
         case 0 ->{
             return lista.get(rowIndex).getId();
         }
         case 1 ->{
             return lista.get(rowIndex).getNome();
         }
     }
     return "";
    }
    
    public void addCliente(cliente c ){
        lista.add(c);
        fireTableRowsUpdated(lista.size()-1, lista.size()-1);
    }
    
     public void limpar(){
        lista.clear();
    }
     
    public cliente pegar(int indice){
        return lista.get(indice);
    }
    
    public void Excluir(int indice){
        lista.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
}
