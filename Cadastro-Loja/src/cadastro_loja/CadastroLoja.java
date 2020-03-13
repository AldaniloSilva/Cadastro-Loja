/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

import Business.Entidade;
import DAO.EntidadeDAO;
import DAO.LeituraCliente;
import DAO.LeituraFuncionario;
import DAO.LeituraPedidos;
import DAO.LeituraProduto;
import java.io.IOException;
/**
 *
 * @author Alipio
 */
public class CadastroLoja {
    public static MaquinaEstadoConsole estadoConsole;
    public static MaquinaEstadoCadastro estadoCadastro;
    public static MaquinaEstadoConsole telaUsuario;
    public static Entidade classeEntidade;
    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        EntidadeDAO.Read("funcionario.txt", new LeituraFuncionario());
        EntidadeDAO.Read("Cliente.txt", new LeituraCliente());
        EntidadeDAO.Read("Pedidos.txt", new LeituraPedidos());
        EntidadeDAO.Read("Produto.txt", new LeituraProduto());
        
      
                
        //System.out.println(EntidadeDAO.RetornaUltimoId("funcionario.txt"));
        
       estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getClasse();        
        Boolean saida = false;
        while (!saida){            
            saida = estadoConsole.Executa();            
        }
    }
    
}
