/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import DAO.EntidadeDAO;
import DAO.LeituraCliente;
import DAO.LeituraFuncionario;
import DAO.LeituraPedidos;
import DAO.LeituraProduto;
import DAO.EnumArquivo;
import java.io.IOException;
/**
 *
 * @author Alipio
 */
public class CadastroLoja {
    public static MaquinaEstadoConsole estadoConsole;
    public static MaquinaEstadoCadastro estadoCadastro;
    public static MaquinaEstadoConsole telaUsuario;  
    public static String mensagemLog;
    public static int acesso;
    public static int opcao;
    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        EntidadeDAO.Read(EnumArquivo.FUNCIONARIO_TXT.getNameFile(), new LeituraFuncionario());
        EntidadeDAO.Read(EnumArquivo.CLIENTE_TXT.getNameFile(), new LeituraCliente());
        EntidadeDAO.Read(EnumArquivo.PEDIDO_TXT.getNameFile(), new LeituraPedidos());
        EntidadeDAO.Read(EnumArquivo.PRODUTO_TXT.getNameFile(), new LeituraProduto());
        
      
                
        //System.out.println(EntidadeDAO.RetornaUltimoId("funcionario.txt"));
        
       estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getClasse();        
        Boolean saida = false;
        while (!saida){            
            saida = estadoConsole.Executa();            
        }
    }
    
}
