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
import java.io.IOException;

/**
 *
 * @author jojok
 */
public class ComunsController {
    
    public static boolean doLogin(boolean asAdmin, Usuario user) throws IOException{
        boolean logado;
        Acesso acesso = new Acesso();
        if(asAdmin)
            logado = acesso.validaUsuarioAdmin(user);
        else
            logado = acesso.validaUsuario(user);
        
        return logado;
    }
    public static void verifyDatabase(){
        Repository repositorio = GenerateRepository.generateRepository(); 
        repositorio.verifyDatabase(Entities.USUARIO);
    }
    public static boolean cadastrarAluno(Usuario u){
        Repository repositorio = GenerateRepository.generateRepository();        
        Usuario usuario = (Usuario)repositorio.find(u.getRA(), Entities.USUARIO);
        if(usuario!= null)
            return false;
        else
        {
            return repositorio.insert(u,Entities.USUARIO);
        }
    }
    public static boolean VerifyPassword(String Password){
        return !(Password.length() < 4 || Password.length() >8);
    }
    public static boolean VerifyName(String Name){
          return !(Name.length() <3 ||Name.length() >20);
    }
    public static boolean VerifyCourse(String Curso){
        return  !(Curso == null  || Curso.isEmpty());
    }
    public static boolean VerifyRA(String RA){
        return !(RA.length() < 4 || RA.length() > 20);
    }
    
    public static boolean atualizarAluno(Usuario u, String Password){
        if(VerifyPassword(Password)){
            return false;
        }
        Repository repositorio = GenerateRepository.generateRepository();        
        repositorio.update(Criptografia.encode(Password), u.getRA(), Entities.USUARIO);
        u.setSenha(Criptografia.encode(Password));
        Usuario.setCurrentUser(u);
        return true;
    }
}
