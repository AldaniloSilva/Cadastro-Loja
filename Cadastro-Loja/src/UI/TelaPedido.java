/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Cliente;
import Business.Entidade;
import Business.Funcionario;
import Business.Pedidos;
import Business.Produto;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreveLog;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import static DAO.LeituraCliente.listaCliente;
import static DAO.LeituraFuncionario.listaFunc;
import DAO.LeituraPedidos;
import static DAO.LeituraPedidos.listaPedidos;
import java.util.List;
import static DAO.LeituraProduto.listaProduto;
import java.util.InputMismatchException;
import java.util.Scanner;

//import java.util.Scanner;
/**
 *
 * @author Alipio
 */
public class TelaPedido extends MaquinaEstadoCadastro {

    String atributo = "Pedido";
    Pedidos pedido = new Pedidos();
    //String [] imprimir = new String [5];

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

        //Pergunta se deseja imprimir
        //System.out.println(MontaImpressao(pedido));

        EscreverEmAqruivo(EnumArquivo.PEDIDO_TXT.getNameFile(), ToString(pedido));
        
        System.out.println(atributo + " cadastrado com sucesso!");
        EscreveLog("Pedido",MontaImpressao(pedido));
        ImprimePedido();
        
        EntidadeDAO.Read(EnumArquivo.PEDIDO_TXT.getNameFile(), new LeituraPedidos());
    }

    @Override
    public void Excluir() {
        System.out.print("Exclusão de Pedidos não está disponível");
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
        for (Entidade item : listaPedidos){
            System.out.println(MontaImpressao((Pedidos)item));
        }
        
    }

    public boolean ValidaCodigo(int codigo, List<Entidade> lista) {
        //return lista.stream().anyMatch((item) -> (item.getCodigo() == codigo));
        for (Entidade item : lista) {
            if (item.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public String ToString(Pedidos pedido) {
        return pedido.getCodigo() + "|" + pedido.getCodigo_produto() + "|" + pedido.getCodigo_cliente()
                + "|" + pedido.getCodigo_funcionario() + "|" + pedido.getQuantidade();
    }

    public String MontaImpressao(Pedidos pedido) {
        String impressao = "Código Pedido:" + Integer.toString(pedido.getCodigo());
        //impressao = listaProduto.stream().filter((item) -> (((Produto) item).getCodigo() == pedido.getCodigo_produto())).map((item) -> " - Descricao" + ((Produto) item).getDescricao()).reduce(impressao, String::concat);
        for (Entidade item : listaProduto) {
            if (((Produto) item).getCodigo() == pedido.getCodigo_produto()) {
                impressao += " - Descricao:" + ((Produto) item).getDescricao();
                break;
            }
        }

        for (Entidade item : listaCliente) {
            if (((Cliente) item).getCodigo() == pedido.getCodigo_cliente()) {
                impressao += " - Cliente:" + ((Cliente) item).getNome();
                break;
            }
        }

        for (Entidade item : listaFunc) {
            if (((Funcionario) item).getCodigo() == pedido.getCodigo_funcionario()) {
                impressao += " - Vendedor:" + ((Funcionario) item).getNome();
            }
        }

        impressao += " - Quantidade: " + Integer.toString(pedido.getQuantidade());
        return impressao;
    }

    public void ImprimePedido() {
        int opcao = -1;
        Scanner in = new Scanner(System.in);

        while (opcao != 0 && opcao != 1){
            try {
                System.out.println("Deseja imprimir o pedido cadastrado?");
                System.out.println("1 -> Sim     0 -> Não:");
                opcao = in.nextInt();
                // in.nextLine();
            } catch (InputMismatchException e) {
                //System.out.println(e.toString());
                System.out.println("\n\n");
                System.out.println(">>>>>Digite APENAS números!<<<<<");
                System.out.println();
            }
        } 

        if (opcao == 1){
            System.out.println(MontaImpressao(pedido));
            System.out.println();
        }
        
    }

}
