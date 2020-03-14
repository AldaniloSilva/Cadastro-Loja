/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Alipio
 */
public enum EnumArquivo {

    PEDIDO_TXT("Pedido.txt"),
    FUNCIONARIO_TXT("Funcionario.txt"),
    CLIENTE_TXT("Cliente.txt"),
    PRODUTO_TXT("Produto.txt"),
    LOG_TXT("Log.txt");

    private final String descricao;

    EnumArquivo(String descricao) {
        this.descricao = descricao;
    }

    public String getNameFile() {
        return descricao;
    }
}
