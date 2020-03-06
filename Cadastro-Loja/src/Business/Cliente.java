/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Alipio
 */
public class Cliente {
    public int codigo;
    public String nome;
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
}
