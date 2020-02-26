/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_loja;

/**
 *
 * @author Alipio
 */
public enum EnumEstadoConsole {
    MENU_PRINCIPAL,
    MENU_LOGIN,
    MENU_CADASTRO,
    MENU_VENDEDOR,
    MENU_GERENTE,
    MENU_CLIENTE,
    MENU_PEDIDO,
    MENU_PRODUTO,
    MENU_FUNCIONARIO;     
    
    private final MaquinaEstadoConsole classe;
    
    
    EnumEstadoConsole( MaquinaEstadoConsole classe){
        this.classe = classe;
    }
    
    public MaquinaEstadoConsole getClasse(){
        return this.classe;
    }
}
