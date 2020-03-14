/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;

/**
 *
 * @author Alipio
 */
public abstract class LimpaTela {
    public static void Clear(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (IOException | InterruptedException e){
                    System.out.println(e);
                }
    }
    
}
