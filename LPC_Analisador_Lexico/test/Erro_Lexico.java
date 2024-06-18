/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Mr.Smart
 */
public class Erro_Lexico {

    int numErros;

    Erro_Lexico() {
        numErros = 0;
    }

    public void reportarErro(String msg, String TokenNome, PosicaoErro pos) {
        System.out.println("Erro: ");

        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '%') {
                System.out.println(TokenNome);
            } else {
                System.out.println(msg.charAt(i));
                System.out.println(" " + pos.start + ".." + pos.finish);
                numErros++;
            }
        }
    }
}
