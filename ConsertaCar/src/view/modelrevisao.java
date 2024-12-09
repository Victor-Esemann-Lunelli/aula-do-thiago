/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.revisao;

/**
 *
 * @author Notebook
 */
public class modelrevisao extends AbstractTableModel {

    List<revisao> lista = new ArrayList<>();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
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
                return "data";
            }
            case 3 -> {
                return "km";
            }
            case 4 -> {
                return "serviços realizados";
            }
            case 5 -> {
                return "automóvel";
            }
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return lista.get(rowIndex).getId();
            }
            case 1 -> {
                var automovel = lista.get(rowIndex).getId_automovel();
                return automovel != null ? automovel.getPlaca() : " ";
            }
            case 2 -> {
                return lista.get(rowIndex).getData();
            }
            case 3 -> {
                return lista.get(rowIndex).getKm();
            }
            case 4 -> {
                return lista.get(rowIndex).getServicos_realizados();
            }
            case 5 -> {
                return lista.get(rowIndex).getId_automovel();
            }
        }
        return "";
    }

    public void addrevisao(revisao r) {
        lista.add(r);
        fireTableRowsUpdated(lista.size() - 1, lista.size() - 1);
    }

    public void limpar() {
        if (!lista.isEmpty()) {
            fireTableRowsDeleted(0, lista.size() - 1);
        }
        lista.clear();
    }

    public revisao pegar(int indice) {
        return lista.get(indice);
    }

    public void Excluir(int indice) {
        lista.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

}
