/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

/**
 *
 * @author 082170001
 */
public class  MaquinaEstadoCadastro {
     boolean sair = false;
     public boolean Cadastrar(String Tipo) 
     {
         System.out.println("Digite o nome do" + Tipo);
         return sair;
     }
     
     public boolean Alterar (String Tipo)
     {
         System.out.println("Digite o nome do" + Tipo);
         return sair;
     }    
     
     public boolean Deletar(String Tipo)
     {
         System.out.println("Digite o código do " + Tipo);
         return sair;
     }
     public boolean Incluir(String Tipo)
     {
        System.out.println("Digite o nome do " + Tipo);
        return sair;  
     }
}
