/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mr.Smart
 */
public class TabelaModelo extends AbstractTableModel {

    public String[] nomeColumn = {"TOKEN", "lexema"};
    public Object[][] dados;

    public TabelaModelo(String[] tokens, String[] lexemas) {
        dados = new Object[tokens.length][2][3];
        for (int i = 0; i < tokens.length; i++) {
            dados[i][0]  = tokens[i];
            dados[i][1]  = lexemas[i];
        }
    }

    @Override
    public int getRowCount() {
        return dados.length;
    }

    @Override
    public int getColumnCount() {
        return nomeColumn.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dados[rowIndex][columnIndex];
    }

}
