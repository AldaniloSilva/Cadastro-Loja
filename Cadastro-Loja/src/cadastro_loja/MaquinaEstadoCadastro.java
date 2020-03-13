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
public abstract class MaquinaEstadoCadastro {

    Scanner entrada = new Scanner(System.in);

    public abstract void Incluir();

    public abstract void Excluir();

    public abstract void Alterar();
    
    public abstract void Listar();
    
    //public abstract String ToString();

    protected int SolicitaCodigo(String atributo) {
        int codigo;
        System.out.print("Digite o código do " + atributo + ": ");
        codigo = entrada.nextInt();
        entrada.nextLine();
        return codigo;
    }    

    
    //public abstract void Listar (String tabela) {}
}
