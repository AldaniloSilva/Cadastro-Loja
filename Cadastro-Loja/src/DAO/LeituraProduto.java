/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Entidade;
import Business.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alipio
 */
public class LeituraProduto extends Leitura {
    
     public static List<Entidade> listaProduto = new ArrayList<>();
     @Override    
    
    public void LerArquivo(String[] dados){
        Produto produto = new Produto();
        produto.setCodigo(Integer.parseInt(dados[0]));
        produto.setDescricao(dados[1]);
        listaProduto.add(produto);
    }
    
}
