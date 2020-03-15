/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static Business.Acesso.RetornaCargo;
import Business.Entidade;
import Business.Funcionario;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreveLog;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import DAO.LeituraFuncionario;
import static DAO.LeituraFuncionario.listaFunc;
import static UI.CadastroLoja.mensagemLog;
import java.util.ArrayList;

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
        //4. Apague da memória os itens da lista
        listaFunc = new ArrayList<>();
        EntidadeDAO.Read(EnumArquivo.FUNCIONARIO_TXT.getNameFile(), new LeituraFuncionario());
    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******");
        int codigo = SolicitaCodigo(atributo);

        //1.Chama o método que quer excluir um elemento
        EntidadeDAO.Excluir(codigo, listaFunc);

        SobreEscreveArquivo();
    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        funcionario.setCodigo(SolicitaCodigo(atributo));

        System.out.println("Digite o nome do " + atributo);
        funcionario.setNome(entrada.nextLine());

        System.out.println("Digite o cargo:");
        System.out.println("0 -> Gerente");
        System.out.println("1 -> Vendedor");

        funcionario.setCargo(entrada.nextInt());
        entrada.nextLine();

        System.out.println("Digite a senha");

        funcionario.setSenha(entrada.nextLine());

        //1.Primeiro substitui o nome
        for (Entidade item : listaFunc) {
            if (((Funcionario) item).getCodigo() == funcionario.getCodigo()) {
                ((Funcionario) item).setNome(funcionario.getNome());
                ((Funcionario) item).setCargo(funcionario.getCargo());
                ((Funcionario) item).setSenha(funcionario.getSenha());
                break;
            }
        }
        SobreEscreveArquivo();

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

    private void SobreEscreveArquivo() {
        //2. Apague o arquivo atual
        EntidadeDAO.DeletarArquivo(EnumArquivo.FUNCIONARIO_TXT.getNameFile());

        //3. Grave os itens da lista
        for (Entidade item : listaFunc) {
            EntidadeDAO.EscreverEmAqruivo(EnumArquivo.FUNCIONARIO_TXT.getNameFile(),
                    (ToString((Funcionario) item)));
        }
        //4. Apague da memória os itens da lista
        listaFunc = new ArrayList<>();
        EntidadeDAO.Read(EnumArquivo.FUNCIONARIO_TXT.getNameFile(), new LeituraFuncionario());
    }

}
