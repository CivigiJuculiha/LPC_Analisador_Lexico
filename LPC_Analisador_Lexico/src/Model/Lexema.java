package Model;
// Generated May 29, 2018 1:23:01 PM by Hibernate Tools 4.3.1

import Controller.Util;
import java.util.ArrayList;

public class Lexema implements java.io.Serializable {

//Variaveis Globais
    String[] p_reservadas = {"div", "or", "and", "not", "if", "then", "else", "of", "uses", "while", "do", "begin", "end", "read", "readln", "writeln", "write", " var ", "array", "function", "procedure", "program", "true", "false", "char", "integer", "boolean"};
    String op_relacionais = "< > <= >= == !=";
    String op_aritmetricos = "+ * / -";
    String[] op_logicos = {"and", "or", "not"};
    String op_atribuicao = ":=";
    String[] delimitadores = {".", ".", ":", "..", ";" ," "};
    String car_especiais = "( ) [ ] { }";
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
    String numeros = "1 ,23456789";
    String idenficador = letras + numeros;
    String tokens;
    ArrayList Arraytokens;

    public Lexema() {
        String tokens;
        Arraytokens = new ArrayList(); //inicializacao do array
    }

    /**
     * Imprimir tokens no background, nem precizam disso 
     */
    public void printTokens() {
        int sz = this.getArraytokens().size();
        for (int i = 0; i < sz; i++) {
            System.out.println(this.getArraytokens().get(i));
        }
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
        ArrayList<String> arrayLex = new ArrayList<String>();

        String[] tmpTokens = getTokens().split(" "); //transforma a string em array, onde divide pelos espacos em pranco
        for (String token : tmpTokens) {
            if (token.isEmpty() || token.equalsIgnoreCase(" ") || token.equals("\t")
                    || token.equals("\n")) {
                continue;
            }

            arrayLex.add(token); //adiciona o token ao arrayLex
        }
        this.setArraytokens(arrayLex);

    }

    /**
     * retorna o array
     * @return 
     */
    public ArrayList getArraytokens() {
        return Arraytokens;
    }

    /**
     * retorna um array de palavras reservadas
     * @return 
     */
    public String[] getp_reservadas() {
        return p_reservadas;
    }

    /**
     * preenche o array Arraytokens 
     * @param Arraytokens 
     */
    protected void setArraytokens(ArrayList Arraytokens) {
        this.Arraytokens = Arraytokens;
    }

    /**
     * Inicializacao das palavras reservada
     * @param p_reservadas 
     */
    public void setp_reservadas(String[] p_reservadas) {
        this.p_reservadas = p_reservadas;
    }

    /**
     * 
     * @return op_relacionais
     */ 
    public String getop_relacionais() {
        return op_relacionais;
    }

    public void setop_relacionais(String op_relacionais) {
        this.op_relacionais = op_relacionais;
    }

    public String getop_aritmetricos() {
        return op_aritmetricos;
    }

    public void setop_aritmetricos(String op_aritmetricos) {
        this.op_aritmetricos = op_aritmetricos;
    }

    public String[] getop_logicos() {
        return op_logicos;
    }

    public void setop_logicos(String[] op_logicos) {
        this.op_logicos = op_logicos;
    }

    public String getop_atribuicao() {
        return op_atribuicao;
    }

    public void setop_atribuicao(String op_atribuicao) {
        this.op_atribuicao = op_atribuicao;
    }

    public String[] getDelimitadores() {
        return delimitadores;
    }

    public void setDelimitadores(String[] delimitadores) {
        this.delimitadores = delimitadores;
    }

    public String getcar_especiais() {
        return car_especiais;
    }

    public void setcar_especiais(String car_especiais) {
        this.car_especiais = car_especiais;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public String getnumeros() {
        return numeros;
    }

    public void setnumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getIdenficador() {
        return idenficador;
    }

    public void setIdenficador(String idenficador) {
        this.idenficador = idenficador;
    }

    public String getTokens() {
        return tokens;
    }

    protected Boolean isP_Reservada(String lexema) {

        for (String token : getp_reservadas()) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isOp_logico(String lexema) {
        for (String token : getop_logicos()) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isOp_aritmetrico(String lexema) {
        String[] lista_token = getop_aritmetricos().split(" ");
        for (String token : lista_token) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isOp_atribuicao(String lexema) {
        String[] lista_token = getop_aritmetricos().split(" ");
        for (String token : lista_token) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isOp_relacional(String lexema) {
        String[] lista_token = getop_relacionais().split(" ");
        for (String token : lista_token) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isDelimitador(String lexema) {
        String[] del = getDelimitadores();
        for (String token : del) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean isCar_Especial(String lexema) {
        String[] lista_token = getcar_especiais().split(" ");
        for (String token : lista_token) {
            if (lexema.equals(token)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se é um identificador
     * @param lexema
     * @return 
     */
    protected Boolean isIdentificador(String lexema) {
        lexema = lexema.trim();

        int letra_sz = this.letras.length();
        int identif_sz = this.idenficador.length();
        int lexema_sz = lexema.length();

        Boolean prefix_ok = false;
        Boolean isIdent = false;

        for (int i = 0; i < letra_sz; i++) {
            if (lexema.charAt(0) == this.letras.charAt(i)) {
                prefix_ok = true;
                break;
            }
        }

        if (prefix_ok == false) {
            Util.debug("sem prefixo??" + lexema);
            return false;
        } else {
            Util.debug("passou!!!");
            for (int i = 1; i < lexema_sz; i++) {
                for (int j = 0; j < identif_sz; j++) {
                    if (lexema.charAt(i) == idenficador.charAt(j)) {
                        isIdent = true;
                        break;
                    }
                }
                if (isIdent == false) {
                    return false;
                }
            }

            return true;
        }

    }

    /**
     * Verifica de que lexema se trata 
     * @param lexema
     * @return 
     */
    public String verificar_lexema(String lexema) {
        String msg;
        if (this.isP_Reservada(lexema)) {
            msg = "Palavra Reservada";
        } else if (this.isOp_atribuicao(lexema)) {
            msg = "Operador de Atribuicao";
        } else if (this.isOp_aritmetrico(lexema)) {
            msg = "Operador Aritmetrico";
        } else if (this.isOp_logico(lexema)) {
            msg = "Operador Logico";
        } else if (this.isCar_Especial(lexema)) {
            msg = "Caracter Especial";
        } else if (this.isDelimitador(lexema)) {
            msg = "delimitador";
        } else if (this.isIdentificador(lexema)) {
            msg = "identificador";
        } else {
            msg = "Erro, sintaxe nao reconhecida";
        }

        return msg;
    }

}
