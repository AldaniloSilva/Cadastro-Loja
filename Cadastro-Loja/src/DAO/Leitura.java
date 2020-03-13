/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.Entidade;
import java.util.List;

/**
 *
 * @author Alipio
 */
public abstract class Leitura {
    
    public abstract void LerArquivo(String[] dados);    
   
        public static int IncluiId(List<Entidade> lista){
            return ((lista.get(lista.size()-1)).getCodigo()+1); 
            
    }
    
}
