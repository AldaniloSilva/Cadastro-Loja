/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

/**
 *
 * @author Alipio
 */
public class CadastroLoja {
    public static MaquinaEstadoConsole estadoConsole;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getClasse();        
        Boolean saida = false;
        while (!saida){
            saida = estadoConsole.Executa();
        }
    }
    
}
