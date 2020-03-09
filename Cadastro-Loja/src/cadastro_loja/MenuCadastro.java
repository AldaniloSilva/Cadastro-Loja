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
public class MenuCadastro extends MaquinaEstadoConsole {
     @Override
    public boolean Executa(){
        boolean sair = false;
        Scanner in = new Scanner(System.in);
        System.out.println("O que deseja fazer?");       
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar");
        int opcao = in.nextInt();
        in.nextLine();
        switch(opcao)
        {
            case 0:
                sair = true;
                break;
            case 1:
                cadastro_loja.CadastroLoja.estadoCadastro.Incluir(); 
                break;              
            case 2:
                cadastro_loja.CadastroLoja.estadoCadastro.Alterar();
                break;
            case 3:
                cadastro_loja.CadastroLoja.estadoCadastro.Excluir();
                break;             
            case 4:
                cadastro_loja.CadastroLoja.estadoCadastro.Listar();                
                break;             
        }
        return sair;     
    }
}

