/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Cliente;
import Business.Entidade;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreveLog;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import DAO.LeituraCliente;
import static DAO.LeituraCliente.listaCliente;
import static UI.CadastroLoja.mensagemLog;
import java.util.ArrayList;
//import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class TelaCliente extends MaquinaEstadoCadastro {

    String atributo = "cliente";
    Cliente cliente = new Cliente();

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******");
        //.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite o nome do " + atributo + ":");
        cliente.setNome(entrada.nextLine());
        System.out.println();

        cliente.setCodigo(Leitura.IncluiId(listaCliente));

        EscreverEmAqruivo(EnumArquivo.CLIENTE_TXT.getNameFile(), ToString(cliente));
        System.out.println(atributo + " cadastrado com sucesso!");
        mensagemLog = "Código: " + Integer.toString(cliente.getCodigo()) + " - "
                + "Nome: " + cliente.getNome();
        EscreveLog("Cliente", mensagemLog);
        //4. Apague da memória os itens da lista
        listaCliente = new ArrayList<>();        
        EntidadeDAO.Read(EnumArquivo.CLIENTE_TXT.getNameFile(), new LeituraCliente());

    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******");
        int codigo = SolicitaCodigo(atributo);

        //1.Chama o método que quer excluir um elemento
        EntidadeDAO.Excluir(codigo, listaCliente);

        SobreEscreveArquivo();
    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        cliente.setCodigo(SolicitaCodigo(atributo));
        System.out.println("Digite outro nome " + atributo + ":");
        cliente.setNome(entrada.nextLine());

        //1.Primeiro substitui o nome
        for (Entidade item : listaCliente) {
            if (((Cliente) item).getCodigo() == cliente.getCodigo()) {
                ((Cliente) item).setNome(cliente.getNome());
                break;
            }
        }
        SobreEscreveArquivo();
    }

    @Override
    public void Listar() {
        System.out.println("***** Lista de " + atributo + " ******");
        //Provavel que precisará de um retorno
        Leitura.ListaTela(listaCliente, EnumArquivo.CLIENTE_TXT);
    }

    public String ToString(Cliente cliente) {
        return cliente.getCodigo() + "|" + cliente.getNome();
    }

    private void SobreEscreveArquivo() {
        //2. Apague o arquivo atual
        EntidadeDAO.DeletarArquivo(EnumArquivo.CLIENTE_TXT.getNameFile());

        //3. Grave os itens da lista
        for (Entidade item : listaCliente) {
            EntidadeDAO.EscreverEmAqruivo(EnumArquivo.CLIENTE_TXT.getNameFile(),
                    (ToString((Cliente) item)));
        }
        //4. Apague da memória os itens da lista
        listaCliente = new ArrayList<>();

        //5. Armazena novamente os dados
        EntidadeDAO.Read(EnumArquivo.CLIENTE_TXT.getNameFile(), new LeituraCliente());

    }
}
