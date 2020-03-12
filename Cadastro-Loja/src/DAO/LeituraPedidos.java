/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Pedidos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alipio
 */
public class LeituraPedidos extends Leitura {
    
     public static List<Pedidos> listaPedidos = new ArrayList<>();
     @Override
    
    
    public void LerArquivo(String[] dados){
        Pedidos pedido = new Pedidos();
        pedido.setCodigo_pedido(Integer.parseInt(dados[0]));
        pedido.setCodigo_cliente(Integer.parseInt(dados[1]));
        pedido.setCodigo_produto(Integer.parseInt(dados[2]));
        pedido.setCodigo_funcionario(Integer.parseInt(dados[3]));
        pedido.setQuantidade(Integer.parseInt(dados[4]));
        listaPedidos.add(pedido);
    }
    
}
