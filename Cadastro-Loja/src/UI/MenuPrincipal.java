/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class MenuPrincipal extends MaquinaEstadoConsole {
    @Override
    public boolean Executa(){
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Bem-vindo!");
        System.out.println("Indique a opção desejada!");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");                  
        int opcao = in.nextInt();
        in.nextLine();
        switch(opcao)
        {
            case 0:
                sair = true;
                break;
            case 1:
                  UI.CadastroLoja.estadoConsole = 
                    EnumEstadoConsole.LOGIN.getClasse();
                break;           
        }
        return sair;
    }
}
