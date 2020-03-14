/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Alipio
 */
public enum EnumEstadoConsole {
    MENU_PRINCIPAL (new MenuPrincipal()),
    LOGIN (new EstadoConsoleLogin()),
    CADASTRO (new MenuCadastro()),
    MENU_VENDEDOR (new MenuVendedor()),
    MENU_GERENTE (new MenuGerente());
    //CADASTRO_CLIENTE,
    //CADASTRO_PEDIDO,
    //CADASTRO_PRODUTO,
    //CADASTRO_FUNCIONARIO;     
    
    private final MaquinaEstadoConsole classe;
    
    
    EnumEstadoConsole( MaquinaEstadoConsole classe){
        this.classe = classe;
    }
    
    public MaquinaEstadoConsole getClasse(){
        return this.classe;
    }
}
