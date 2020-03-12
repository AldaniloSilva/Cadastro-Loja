/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import Business.Pedidos;
//import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class TelaPedido extends MaquinaEstadoCadastro {

    String atributo = "pedido";
    Pedidos pedido = new Pedidos();

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******");
        //pedido.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite o código do produto:");
        pedido.setCodigo_produto(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite a quantidade:");
        pedido.setQuantidade(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite o código do cliente:");
        pedido.setCodigo_cliente(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite o código do funcionário:");
        pedido.setCodigo_funcionario(entrada.nextInt());
        entrada.nextLine();
    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******");
        int codigo = SolicitaCodigo(atributo);
    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        System.out.println("Não é possível alterar um pedido!");
    }

    @Override
    public void Listar() {
        //Provavel que precisará de um retorno
        System.out.println("Vamos listar todo conteudo da lista de "
                + atributo);
        System.out.println("Método será implementado em breve");
    }
}
