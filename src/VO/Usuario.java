/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Comuns.CampoNoBanco;
import Comuns.Criptografia;
import java.util.ArrayList;

/**
 *
 * @author jojok
 */
public class Usuario extends Entity {
    
    @CampoNoBanco(nome = "RA", chave = true)
    private String RA;
    
    @CampoNoBanco(nome = "Nome", chave = false)
    private String Nome;
    
    @CampoNoBanco(nome = "Senha", chave = false)
    private String Senha;
    
    @CampoNoBanco(nome = "Categoria", chave = false)
    private String Categoria;
    
    @CampoNoBanco(nome = "Curso", chave = false)
    private String Curso;
    
    @CampoNoBanco(nome = "Semestre", chave = false)
    private int Semestre;
    
    private static Usuario currentUser;
 
    public Usuario() {
    }
 
    public static synchronized Usuario getCurrentUser() {
        if (currentUser == null)
            currentUser = new Usuario();
 
        return currentUser;
    }
    public static void setCurrentUser(Usuario u){
        currentUser = u;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }
    
    public String getRA() {
        return  RA;
    }
    
    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    public String getDecriptedPassword(){
        return Criptografia.decode(getSenha());
    }
   
    public ArrayList<Object> getUserArray(){
        ArrayList<Object> UserSettings = new ArrayList<>();
        UserSettings.add(getRA());
        UserSettings.add(getNome());
        UserSettings.add(Criptografia.encode(getSenha()));
        UserSettings.add(getCategoria());
        UserSettings.add(getCurso());
        UserSettings.add(getSemestre());
        return UserSettings;
    }
    
    
}
