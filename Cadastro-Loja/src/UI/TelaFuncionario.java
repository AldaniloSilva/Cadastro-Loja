/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static Business.Acesso.RetornaCargo;
import Business.Funcionario;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreveLog;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import DAO.LeituraFuncionario;
import static DAO.LeituraFuncionario.listaFunc;
import static UI.CadastroLoja.mensagemLog;

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
        System.out.println("***** Incluir " + atributo + " ******");

        System.out.println("Digite o nome do " + atributo);
        funcionario.setNome(entrada.nextLine());

        System.out.println("Digite o cargo:");
        System.out.println("0 -> Gerente");
        System.out.println("1 -> Vendedor");

        funcionario.setCargo(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite a senha");

        funcionario.setSenha(entrada.nextLine());

        funcionario.setCodigo(Leitura.IncluiId(listaFunc));

        EscreverEmAqruivo(EnumArquivo.FUNCIONARIO_TXT.getNameFile(), ToString(funcionario));
        System.out.println(atributo + " cadastrado com sucesso!");

        mensagemLog = "Código: " + Integer.toString(funcionario.getCodigo()) + " - "
                + "Nome: " + funcionario.getNome() + " - " + "Cargo: " + RetornaCargo(funcionario.getCargo());
        EscreveLog("Funcionario", mensagemLog);
        EntidadeDAO.Read(EnumArquivo.FUNCIONARIO_TXT.getNameFile(), new LeituraFuncionario());
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
        //Aqui estamos aproveitando o mesmo EnumArquivo para ajudar
        //Na escolha da listagem do ListaTela, porém o arquivo não está sendo explorado
        System.out.println("***** Lista de " + atributo + " ******");
        Leitura.ListaTela(listaFunc, EnumArquivo.FUNCIONARIO_TXT);
    }

    public String ToString(Funcionario func) {
        return func.getCodigo() + "|" + func.getNome() + "|" + func.getCargo()
                + "|" + func.getSenha();
    }

}

//funcionario.setCodigo(listaFunc.size()+1);
//System.out.println((listaFunc.get(listaFunc.size()-1)).getCodigo()+1);
//funcionario.setCodigo((listaFunc.get(listaFunc.size() - 1)).getCodigo() + 1);
//cadastro_loja.CadastroLoja.classeEntidade = EnumEntidade.FUNCIONARIO.getClasse();
        //cadastro_loja.CadastroLoja.classeEntidade = funcionario;
