/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import Business.Funcionario;
import static DAO.EntidadeDAO.listaFunc;

//import java.util.Scanner;
/**
 *
 * @author Alipio
 */
public class TelaFuncionario extends MaquinaEstadoCadastro {

    private final String atributo = "funcionario";
    Funcionario funcionario = new Funcionario();

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******" );
        //.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite o nome do " + atributo);
        funcionario.setNome(entrada.nextLine());

        System.out.println("Digite o cargo:");
        System.out.println("0 -> Gerente");
        System.out.println("1 -> Vendedor");

        funcionario.setCargo(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite a senha");

        funcionario.setSenha(entrada.nextLine());
        
        funcionario.setCodigo(listaFunc.size()+1);
        
        System.out.println(listaFunc.size()+1);
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
        System.out.println("Digite o nome do " + atributo);
        funcionario.setNome(entrada.nextLine());

        System.out.println("Digite o cargo:");
        System.out.println("0 -> Gerente");
        System.out.println("1 -> Vendedor");

        funcionario.setCargo(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite a senha");

        funcionario.setSenha(entrada.nextLine());

    }

    @Override
    public void Listar() {
        //Provavel que precisará de um retorno
        System.out.println("Vamos listar todo conteudo da lista de "
                + atributo);
        System.out.println("Método será implementado em breve");
    }

}
