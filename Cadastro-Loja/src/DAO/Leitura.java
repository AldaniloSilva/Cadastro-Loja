/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Acesso;
import Business.Cliente;
import Business.Entidade;
import Business.Funcionario;
import Business.Produto;
import java.util.List;

/**
 *
 * @author Alipio
 */
public abstract class Leitura {

    public abstract void LerArquivo(String[] dados);

    public static int IncluiId(List<Entidade> lista) {
        if (lista.isEmpty()) {
            return 1;
        } else {
            return ((lista.get(lista.size() - 1)).getCodigo() + 1);
        }
    }

    public static void ListaTela(List<Entidade> lista, EnumArquivo arquivo) {
        switch (arquivo) {
            case FUNCIONARIO_TXT:
                for (Entidade item : lista) {
                    System.out.println(
                            "Código:" + ((Funcionario) item).getCodigo() + " - "
                            + "Nome:" + ((Funcionario) item).getNome() + " - "
                            + "Cargo:" + Acesso.RetornaCargo(((Funcionario) item).getCargo())
                    );
                }
                break;

            case PRODUTO_TXT:
                for (Entidade item : lista) {
                    System.out.println(
                            "Código:" + ((Produto) item).getCodigo() + " - "
                            + "Descricao:" + ((Produto) item).getDescricao());
                    
                }
                System.out.println();
                break;

            case CLIENTE_TXT:
                for (Entidade item : lista) {
                    System.out.println(
                            "Código:" + ((Cliente) item).getCodigo() + " - "
                            + "Descricao:" + ((Cliente) item).getNome());
                   
                                    }
                 System.out.println();
                break;
        }

    }

}
