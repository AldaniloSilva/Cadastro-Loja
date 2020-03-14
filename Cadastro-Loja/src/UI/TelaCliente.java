/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Cliente;
import DAO.EntidadeDAO;
import static DAO.EntidadeDAO.EscreverEmAqruivo;
import DAO.EnumArquivo;
import DAO.Leitura;
import DAO.LeituraCliente;
import static DAO.LeituraCliente.listaCliente;
//import java.util.Scanner;

/**
 *
 * @author Alipio
 */
public class TelaCliente extends MaquinaEstadoCadastro {

    String atributo = "cliente";
    Cliente cliente = new Cliente();

    @Override
    public void Incluir() {
        System.out.println("***** Incluir " + atributo + " ******");
        //.setCodigo(SolicitaCodigo(atributo));
        //Deverá ser implementado um método para pegar o próximo número
        System.out.println("Digite o nome do " + atributo + ":");
        cliente.setNome(entrada.nextLine());
        System.out.println();
        //EntidadeDAO.EscreverEmAqruivo();
        
        //int numero  = ((listaCliente.get(listaCliente.size()-1)).getCodigo()+1);
        
        //System.out.println(numero);
                
       // cliente.setCodigo((listaCliente.get(listaCliente.size()-1)).getCodigo()+1);
        
        cliente.setCodigo(Leitura.IncluiId(listaCliente));

        EscreverEmAqruivo(EnumArquivo.CLIENTE_TXT.getNameFile(), ToString(cliente));
        EntidadeDAO.Read(EnumArquivo.CLIENTE_TXT.getNameFile(), new LeituraCliente());    
 
    }

    @Override
    public void Excluir() {
        System.out.println("***** Excluir " + atributo + " ******");
        int codigo = SolicitaCodigo(atributo);
        
    }

    @Override
    public void Alterar() {
        System.out.println("***** Alterar " + atributo + " ******");
        //Depois quando tiver funcionando Juntar esse método com o Incluir
        cliente.setCodigo(SolicitaCodigo(atributo));
        System.out.println("Digite o nome do " + atributo + ":");
        cliente.setNome(entrada.nextLine());        
    }

    @Override
    public void Listar() {
        System.out.println("***** Lista de " + atributo + " ******");
        //Provavel que precisará de um retorno
        Leitura.ListaTela(listaCliente, EnumArquivo.CLIENTE_TXT);
    }
    
     public String ToString (Cliente cliente) {
        return cliente.getCodigo() + "|" + cliente.getNome();        
    }
}
