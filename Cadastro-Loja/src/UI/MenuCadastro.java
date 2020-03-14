/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Acesso;
import static UI.CadastroLoja.acesso;
import static UI.CadastroLoja.estadoConsole;
import java.util.Scanner;

/**
 *
 * @author 082170001
 */
public class MenuCadastro extends MaquinaEstadoConsole {

    @Override
    public boolean Executa() {
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println("O que deseja fazer?");
        System.out.println("0 - Sair");
        System.out.println("1 - Menu Principal");
        System.out.println("2 - Cadastrar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Listar");
        int opcao = in.nextInt();
        in.nextLine();
        switch (opcao) {
            case 0:
                sair = true;
                break;
            case 1:
                estadoConsole = Acesso.VerificaAcesso(acesso);
                break;
            case 2:
                UI.CadastroLoja.estadoCadastro.Incluir();
                break;
            case 3:
                UI.CadastroLoja.estadoCadastro.Alterar();
                break;
            case 4:
                UI.CadastroLoja.estadoCadastro.Excluir();
                break;
            case 5:
                UI.CadastroLoja.estadoCadastro.Listar();
                break;
        }
        return sair;
    }
}
