/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alipio
 */
public class EstadoConsoleLogin extends MaquinaEstadoConsole {
    @Override
     public boolean Executa(){
        boolean sair = false;
        //Usuario user = new Usuario();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu usuário");
        //user.setLogin(scan.nextLine());
        //Apenas para testar
        String user = scan.next();
        System.out.println("Digite sua senha");
        String senha = scan.next();
        
        //user.setSenha(scan.nextLine());
        // TODO - Validação de senha
        //Acesso acesso = new Acesso();
        //boolean senhaValida = acesso.validaUsuario(user);
        if (ValidaSenha(user,senha)){
            
            cadastro_loja.CadastroLoja.estadoConsole = 
                    EnumEstadoConsole.MENU_GERENTE.getClasse();
                return sair;
        }
            //CRUD.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
            else {
                System.out.println("Dados inválidos!");
                return !sair; 
        }
        }            
        
     private boolean ValidaSenha(String user, String login) {
        return user.equals("alipio") && (login.equals("123"));
     }

}