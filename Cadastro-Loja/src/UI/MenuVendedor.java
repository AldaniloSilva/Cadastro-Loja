/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author 082170001
 */
public class MenuVendedor extends MaquinaEstadoConsole {
        @Override
    public boolean Executa(){
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println("*** Menu Vendendor ***");
        System.out.println("Indique a opção desejada!");       
        System.out.println("0 - Sair");
        System.out.println("1 - Produtos");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Cliente");
        int opcao = in.nextInt();
        in.nextLine();
        switch(opcao)
        {
            case 0:
                sair = true;
            case 1:
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.PRODUTO.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;
            case 2:
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.PEDIDO.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;
            case 3:
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.CLIENTE.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;                
        }
        return sair;
    }
}