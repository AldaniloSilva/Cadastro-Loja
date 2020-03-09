/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import DAO.EntidadeDAO;
/**
 *
 * @author Alipio
 */
public class CadastroLoja {
    public static MaquinaEstadoConsole estadoConsole;
    public static MaquinaEstadoCadastro estadoCadastro;
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String texto = EntidadeDAO.Read("funcionario.txt");
        if(texto.isEmpty())
            System.out.println("Erro ao ler arquivo!");
        else
            System.out.println(texto);
        
       estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getClasse();        
        Boolean saida = false;
        while (!saida){            
            saida = estadoConsole.Executa();            
        }
    }
    
}
