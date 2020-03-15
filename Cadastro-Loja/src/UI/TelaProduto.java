/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Entidade;
import Business.Pedidos;
import Business.Produto;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreveLog;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import static DAO.LeituraPedidos.listaPedidos;
import DAO.LeituraProduto;
import static DAO.LeituraProduto.listaProduto;
import static UI.CadastroLoja.mensagemLog;
import java.util.ArrayList;

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
        System.out.println(atributo + " cadastrado com sucesso!");

        mensagemLog = "Código: " + Integer.toString(produto.getCodigo()) + " - "
                + "Descricao: " + produto.getDescricao();

        EscreveLog("Produto", mensagemLog);
        EntidadeDAO.Read(EnumArquivo.PRODUTO_TXT.getNameFile(), new LeituraProduto());

    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******");
        int codigo = SolicitaCodigo(atributo);
        //1.Primeiro verifica se não tem nenhum pedido associado a esse produto
        if (TemProdutoComPedido(codigo)) {
            System.out.println("Não é possível excluir esse produto, "
                    + "tem pedidos associados a ele");
        } else {
            //1.Primeiro substitui o nome
            for (Entidade item : listaProduto) {
                if (((Produto) item).getCodigo() == produto.getCodigo()) {
                    ((Produto) item).setDescricao(produto.getDescricao());
                    break;
                }
            }
            EntidadeDAO.Excluir(codigo, listaProduto);

            SobreEscreveArquivo();

        }

    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        produto.setCodigo(SolicitaCodigo(atributo));
        System.out.println("Digite a descrição do " + atributo + ":");
        produto.setDescricao(entrada.nextLine());

        //1.Primeiro substitui o nome
        for (Entidade item : listaProduto) {
            if (((Produto) item).getCodigo() == produto.getCodigo()) {
                ((Produto) item).setDescricao(produto.getDescricao());
                break;
            }
        }
        SobreEscreveArquivo();
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

    public boolean TemProdutoComPedido(int codigo) {
        for (Entidade item : listaPedidos) {
            if (((Pedidos) item).getCodigo_produto() == codigo) {
                return true;
            }
        }

        return false;
    }

    private void SobreEscreveArquivo() {
        //2. Apague o arquivo atual
        EntidadeDAO.DeletarArquivo(EnumArquivo.PRODUTO_TXT.getNameFile());

        //3. Grave os itens da lista
        for (Entidade item : listaProduto) {
            EntidadeDAO.EscreverEmAqruivo(EnumArquivo.PRODUTO_TXT.getNameFile(),
                    (ToString((Produto) item)));
        }
        //4. Apague da memória os itens da lista
        listaProduto = new ArrayList<>();
        EntidadeDAO.Read(EnumArquivo.PRODUTO_TXT.getNameFile(), new LeituraProduto());

    }

}
