/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import java.util.Scanner;

/**
 *
 * @author 082170001
 */
public class MenuGerente extends MaquinaEstadoConsole {
     @Override
    public boolean Executa(){
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("*** Menu Gerente****");
        System.out.println("Indique a opção desejada:");       
        System.out.println("0 - Sair");
        System.out.println("1 - Produtos");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Cliente");
        System.out.println("4 - Funcionários");
        int opcao = in.nextInt();
        in.nextLine();
        switch(opcao)
        {
            case 0:
                sair = true;
                break;
            case 1:
                sair = true;
                break;              
            case 2:
                sair = true;
                break;
            case 3:
                sair = true;
                break;             
            case 4:
                sair = true;
                break;              
         }
        return sair;     
    }
}
