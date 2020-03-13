/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;
import Business.Funcionario;
import Business.Produto;

/**
 *
 * @author 082170001
 */
public enum EnumEntidade {

    PRODUTO (new ArrayList()),
    FUNCIONARIO(),
    PEDIDO(),
    CLIENTE();
    //public static List<Entidade> listaCliente = new ArrayList<>();

    private final List<Entidade> lista;

    EnumEntidade(List<Entidade> lista) {
        this.lista = lista;
    }

    public Entidade getClasse() {
        return this.lista;
    }

}

}
