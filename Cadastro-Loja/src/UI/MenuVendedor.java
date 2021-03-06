/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Acesso;
import static UI.CadastroLoja.acesso;
import static UI.CadastroLoja.estadoConsole;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 082170001
 */
public class MenuVendedor extends MaquinaEstadoConsole {

    @Override
    public boolean Executa() {
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println("***************************\n"
                + "*  ---- Menu Vendedor ---- *\n"
                + "***************************"
        );
        System.out.println("Indique a opção desejada!");
        System.out.println("0 - Sair");
        System.out.println("1 - Menu Principal");
        System.out.println("2 - Produtos");
        System.out.println("3 - Pedidos");
        System.out.println("4 - Cliente");
        try {
            UI.CadastroLoja.opcao = in.nextInt();
            // in.nextLine();
        } catch (InputMismatchException e) {
            //System.out.println(e.toString());
            System.out.println("\n\n");
            System.out.println(">>>>>Digite APENAS números!<<<<<");
            System.out.println();
            return sair;
        }
        switch (UI.CadastroLoja.opcao) {
            case 0:
                sair = true;

            case 1:
                estadoConsole = Acesso.VerificaAcesso(acesso);
                break;
            case 2:
                System.out.println("***************************\n"
                        + "*  ---- Produtos  ---- *\n"
                        + "***************************"
                );
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.PRODUTO.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;
            case 3:
                System.out.println("***************************\n"
                        + "*  ---- Pedidos  ---- *\n"
                        + "***************************"
                );
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.PEDIDO.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;
            case 4:
                System.out.println("***************************\n"
                        + "*  ---- Cliente  ---- *\n"
                        + "***************************"
                );
                UI.CadastroLoja.estadoCadastro
                        = EnumEstadoCadastro.CLIENTE.getClasse();
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.CADASTRO.getClasse();
                break;

            default:
                System.out.println("\n\n");
                System.out.println("Opção Inválida!");
                System.out.println();
                System.out.println("***************************\n"
                        + "*  ---- Menu Vendedor  ---- *\n"
                        + "***************************"
                );
                UI.CadastroLoja.estadoConsole
                        = EnumEstadoConsole.MENU_VENDEDOR.getClasse();
                break;
        }
        return sair;
    }
}
