/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Comuns.Criptografia;
import Enums.Entities;
import Repository.GenerateRepository;
import Repository.Repository;
import VO.Usuario;

/**
 *
 * @author jojok
 */
public class Acesso {
    private boolean validaSenha(String senhaRepositorio, String senhaDigitada){
        
        senhaRepositorio = Criptografia.decode(senhaRepositorio);
        
        return (senhaRepositorio.equals(senhaDigitada)); 
    }
    
    private Usuario validaUsuarioBase(Usuario user){
        
        Repository repositorio = GenerateRepository.generateRepository();        
        Usuario usuario = (Usuario)repositorio.find(user.getRA(), Entities.USUARIO);
        Usuario.setCurrentUser(usuario);
        return usuario;
    }
    public boolean validaUsuario(Usuario user) {
        
        boolean retorno = false;
        Usuario usuario = validaUsuarioBase(user);
        if (usuario != null)
        {
            retorno = validaSenha(usuario.getSenha(), user.getSenha());
        }
        return retorno;
    }
    public boolean validaUsuarioAdmin(Usuario user){
       
        boolean retorno = false;
        Usuario usuario = validaUsuarioBase(user);
        if (usuario != null)
        {
            retorno = validaSenha(usuario.getSenha(), user.getSenha()) && usuario.getCategoria().equals("Administrador");
        }
        return retorno;
    }
}
