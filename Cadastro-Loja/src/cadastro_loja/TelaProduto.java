/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import Business.Produto;
//import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class TelaProduto extends MaquinaEstadoCadastro {

    String atributo;// = "produto";
    Produto produto = new Produto();
    
    public TelaProduto(){
       this.atributo = "produto";
}

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******" );
        //produto.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite a descrição do " + atributo + ":");
        produto.setDescricao(entrada.nextLine());

    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******" );
        int codigo = SolicitaCodigo(atributo);
    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        produto.setCodigo(SolicitaCodigo(atributo));
        System.out.println("Digite a descrição do " + atributo + ":");
        produto.setDescricao(entrada.nextLine());
    }
    
    @Override
      public void Listar () {
        //Provavel que precisará de um retorno
        System.out.println("Vamos listar todo conteudo da lista de "
        + atributo);
        System.out.println("Método será implementado em breve");
    }
    
  }

