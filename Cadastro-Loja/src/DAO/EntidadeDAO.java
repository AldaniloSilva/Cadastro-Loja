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
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Alipio
 */
public class EntidadeDAO {

    //public static List<Funcionario> listaFunc = new ArrayList<>();
    public static void EscreverEmAqruivo(String arquivo, String dados) {

        try {
            try (FileWriter x = new FileWriter(arquivo, true)) {
                //String gravaTeste = ;
                x.write(dados + "\r\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    

    public static void Read(String arquivo, Leitura classeLeitura) {
        //String conteudo = "";
        String sentenca[];

        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            try {
                linha = lerArq.readLine();
                if (linha != null) {
                    sentenca = linha.split(Pattern.quote("|"));
                    // LeFuncionario(sentenca);
                    classeLeitura.LerArquivo(sentenca);
                }

                while (linha != null) {
                    //conteudo += linha+"\r\n";                    
                    linha = lerArq.readLine();
                    if (linha != null) {
                        sentenca = linha.split(Pattern.quote("|"));
                        //LeFuncionario(sentenca);
                        classeLeitura.LerArquivo(sentenca);
                    }

                }
                arq.close();
            } catch (IOException ex) {
                System.out.println(ex);
                System.out.println("Erro: Não foi possível ler o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Erro: Arquivo não encontrado!");
        }
    }

    public static void EscreveLog(String tipo, String texto) {
        Date dataAtual = new Date();
        tipo += "--> " + texto + " - " + dataAtual.toString();
        EscreverEmAqruivo(EnumArquivo.LOG_TXT.getNameFile(), tipo);
        
    }
}
