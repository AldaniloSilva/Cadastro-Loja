/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import UI.MaquinaEstadoConsole;
import UI.EnumEstadoConsole;

/**
 *
 * @author Alipio
 */
public abstract class Acesso {
    
    public static MaquinaEstadoConsole VerificaAcesso (int numero) {
        if (numero == 0)
            return EnumEstadoConsole.MENU_GERENTE.getClasse();
        else
            return EnumEstadoConsole.MENU_VENDEDOR.getClasse();            
    }
    
}
