/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.automovel;

/**
 *
 * @author Notebook
 */
public class modelautomovel extends AbstractTableModel{
    
    private List<automovel>lista = new ArrayList<>();

    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "id";
            }
            case 1 -> {
                return "placa";
            }
            case 2 -> {
                return "marca";
            }
            case 3 -> {
                return "modelo";
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
             return lista.get(rowIndex).getPlaca();
         }
         case 2 ->{
             return lista.get(rowIndex).getMarca();
         }
         case 3 ->{
             return lista.get(rowIndex).getModelo();
         }
     }
     return "";
    }
    
    public void addAutomovel(automovel a){
        lista.add(a);
         fireTableRowsUpdated(lista.size()-1, lista.size()-1);
    }
    
    public void limpar(){
        lista.clear();
    }
    
    public automovel pegar(int indice){
        return lista.get(indice);
    }
    
     public void Excluir(int indice){
        lista.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
}
