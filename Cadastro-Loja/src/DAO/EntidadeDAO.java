/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import Business.Cliente;
import Business.Funcionario;
import Business.Pedidos;
import Business.Produto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

/**
 *
 * @author Alipio
 */
public class EntidadeDAO {

    public static List<Funcionario> listaFunc = new ArrayList<>();

    public static void EscreverEmAqruivo(String arquivo, String dados) {

        try {
            try (FileWriter x = new FileWriter("cliente.txt", true)) {
                String gravaTeste = "Jesus is Perfect.\r\n";
                x.write(gravaTeste);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void LeFuncionario(String[] dados) {
        //Esse método trabalha com a leitura de dados
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(Integer.parseInt(dados[0]));
        funcionario.setNome(dados[1]);
        funcionario.setCargo(Integer.parseInt(dados[2]));
        funcionario.setSenha(dados[3]);
        listaFunc.add(funcionario);
    }

    /*
    private static String EscreveFuncionario (Funcionario func) {
        //Esse método trabalha com escrita de dados
        String dados;        
    }*/

    public static String Read(String arquivo) {
        String conteudo = "";
        String sentenca[];

        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                sentenca = linha.split(Pattern.quote("|"));
                LeFuncionario(sentenca);

                while (linha != null) {
                    //conteudo += linha+"\r\n";                    
                    linha = lerArq.readLine();
                    if (linha != null) {
                        sentenca = linha.split(Pattern.quote("|"));
                        LeFuncionario(sentenca);
                    }
                    
                }
                arq.close();
            } catch (IOException ex) {
                conteudo = "Erro: Não foi possível ler o arquivo!";
            }
        } catch (FileNotFoundException ex) {
            conteudo = "Erro: Arquivo não encontrado!";
        }

        if (conteudo.contains("Erro")) {
            return conteudo;
        } else {
            return conteudo;
        }

    }

    /*
    private static void ConverterFuncionarios(String[] sentenca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
