


import View.TelaPrincipal;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Mr.Smart
 */
public class TabelaLexica extends AbstractTableModel {

    private static final int NR_COLUNAS = 2;//Nr de Colunas
    private static final String[] colunasNomes = {"Token", "lexema"};//Nomes das colunas
    private static List<Lexema> list;//Lista a ser populada na tabela 
    private final Class<?>[] colunaTipos = {String.class, String.class};//Tipo de dado a ser recebido em cada coluna

    public TabelaLexica(List<Lexema> list) {
        TabelaLexica.list = list;

    }

    //Metodo para pegar a posicao de cada dado
    public static Lexema getLexmeaAt(int index) {
        return list.get(index);
    }

    @Override//Metodo que conta o nr de linhas consoante a lista
    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override//Metodo que conta o nr de colunas consoante a lista
    public int getColumnCount() {
        return NR_COLUNAS;
    }

    @Override//Metodo que pega o nome da coluna consoante a lista
    public String getColumnName(int column) {
        return colunasNomes[column];
    }
    String codigo = "";

    @Override//Metodo que pega o tipo de dado consoante a lista
    public Class<?> getColumnClass(int coluna) {
        return colunaTipos[coluna];
    }

    @Override//Metodo que pega os valores do Objecto Modelo para cada linha e coluna e lista na tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lexema c = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getDescricaolexema();
            case 1:
                return c.getDescricaoToken();
        }
        return null;
    }
}
