/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alipio
 */
public class LeituraCliente extends Leitura {

    public static List<Cliente> listaCliente = new ArrayList<>();

    @Override

    public void LerArquivo(String[] dados) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(Integer.parseInt(dados[0]));
        cliente.setNome(dados[1]);
        listaCliente.add(cliente);
    }

}
