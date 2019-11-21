/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import VO.Usuario;
import java.io.IOException;

/**
 *
 * @author jojok
 */
public class LoginController {
    
    public static boolean DoLogin(boolean asAdmin, Usuario user) throws IOException{
        boolean logado;
        Acesso acesso = new Acesso();
        if(asAdmin)
            logado = acesso.validaUsuarioAdmin(user);
        else
            logado = acesso.validaUsuario(user);
        
        return logado;
    }
}
