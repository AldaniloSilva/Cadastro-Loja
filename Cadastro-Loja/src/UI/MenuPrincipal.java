/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class MenuPrincipal extends MaquinaEstadoConsole {

    /*
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
    }*/
    @Override
    public boolean Executa() {
        boolean sair = false;
        int opcao;
        Scanner in = new Scanner(System.in);
        System.out.println("Bem-vindo!");
        System.out.println("Indique a opção desejada:");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");
        try {
            opcao = in.nextInt();
            // in.nextLine();
        } catch (InputMismatchException e) {
            //System.out.println(e.toString());
            System.out.println("\n\n");
            System.out.println(">>>>>Digite APENAS números!<<<<<");
            System.out.println();
            return sair;
        }

        switch (opcao) {
            case 0:
                sair = true;
                break;
            case 1:
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.LOGIN.getClasse();
                break;

            default:
                System.out.println("\n\n");
                System.out.println("Opção Inválida!");
                System.out.println();
                System.out.println("***************************\n"
                        + "*  ---- Menu Principal  ---- *\n"
                        + "***************************"
                );
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.MENU_PRINCIPAL.getClasse();
        }
        return sair;
    }
}
