/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Entidade;
import Business.Pedidos;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import static DAO.LeituraCliente.listaCliente;
import static DAO.LeituraFuncionario.listaFunc;
import DAO.LeituraPedidos;
import static DAO.LeituraPedidos.listaPedidos;
import java.util.List;
import static DAO.LeituraProduto.listaProduto;
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
        if (!ValidaCodigo(pedido.getCodigo_produto(), listaProduto)) {
            System.out.println("Código de produto não existe!");
        }

        System.out.println("Digite o código do cliente:");
        pedido.setCodigo_cliente(entrada.nextInt());
        entrada.nextLine();
        if (!ValidaCodigo(pedido.getCodigo_cliente(), listaCliente)) {
            System.out.println("Código do cliente não existe!");
        }

        System.out.println("Digite o código do vendedor:");
        pedido.setCodigo_funcionario(entrada.nextInt());
        entrada.nextLine();
        if (!ValidaCodigo(pedido.getCodigo_funcionario(), listaFunc)) {
            System.out.println("Código do vendedor não existe!");
        }

        System.out.println("Digite a quantidade:");
        pedido.setQuantidade(entrada.nextInt());
        entrada.nextLine();

        pedido.setCodigo(Leitura.IncluiId(listaPedidos));

        EscreverEmAqruivo(EnumArquivo.PEDIDO_TXT.getNameFile(), ToString(pedido));
        EntidadeDAO.Read(EnumArquivo.PEDIDO_TXT.getNameFile(), new LeituraPedidos());
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

    public boolean ValidaCodigo(int codigo, List<Entidade> lista) {
        //return lista.stream().anyMatch((item) -> (item.getCodigo() == codigo));
        for (Entidade item : lista) {
            if (item.getCodigo() == codigo) {
                return true;
            }
        }
        return false;    }
    
        public String ToString(Pedidos pedido) {
        return pedido.getCodigo() + "|" + pedido.getCodigo_produto() + "|" + pedido.getCodigo_cliente()
                + "|" + pedido.getCodigo_funcionario() + "|" + pedido.getQuantidade();
    }

}
