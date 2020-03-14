/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Produto;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import DAO.LeituraCliente;
import DAO.LeituraProduto;
import static DAO.LeituraProduto.listaProduto;
//import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class TelaProduto extends MaquinaEstadoCadastro {

    String atributo;// = "produto";
    Produto produto = new Produto();

    public TelaProduto() {
        this.atributo = "produto";
    }

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******");
        //produto.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite a descrição do " + atributo + ":");
        produto.setDescricao(entrada.nextLine());

        produto.setCodigo(Leitura.IncluiId(listaProduto));

        EscreverEmAqruivo(EnumArquivo.PRODUTO_TXT.getNameFile(), ToString(produto));
        EntidadeDAO.Read(EnumArquivo.PRODUTO_TXT.getNameFile(), new LeituraProduto());

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
        produto.setCodigo(SolicitaCodigo(atributo));
        System.out.println("Digite a descrição do " + atributo + ":");
        produto.setDescricao(entrada.nextLine());
    }

    @Override
    public void Listar() {
        //Provavel que precisará de um retorno
        System.out.println("***** Lista de " + atributo + " ******");
        Leitura.ListaTela(listaProduto, EnumArquivo.PRODUTO_TXT);
    }

    public String ToString(Produto produto) {
        return produto.getCodigo() + "|" + produto.getDescricao();
    }

}
