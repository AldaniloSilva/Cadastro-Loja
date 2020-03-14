/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Entidade;
import Business.Funcionario;
//import static DAO.EntidadeDAO.listaFunc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alipio
 */
public class LeituraFuncionario extends Leitura {
    public static List<Entidade> listaFunc = new ArrayList<>();

 @Override
    
    
    public void LerArquivo(String[] dados){
         //Esse método trabalha com a leitura de dados
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(Integer.parseInt(dados[0]));
        funcionario.setNome(dados[1]);
        funcionario.setCargo(Integer.parseInt(dados[2]));
        funcionario.setSenha(dados[3]);
        listaFunc.add(funcionario);
    }
}
