/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Comuns.CampoNoBanco;
import Enums.Category;

/**
 *
 * @author jojok
 */
public class Usuario extends Entity {
    
    @CampoNoBanco(nome = "Nome", chave = false)
    private String Nome;
    @CampoNoBanco(nome = "Sobrenome", chave = false)
    private String Sobrenome;
    
    private Category Categoria;
    
    private Curso Curso;
    
    private Semestre Semestre;
    
    @CampoNoBanco(nome = "Username", chave = true)
    private String Username;
    
    @CampoNoBanco(nome = "Senha", chave = false)
    private String Senha;


    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public Category getCategoria() {
        return Categoria;
    }

    public void setCategoria(Category Categoria) {
        this.Categoria = Categoria;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public Semestre getSemestre() {
        return Semestre;
    }

    public void setSemestre(Semestre Semestre) {
        this.Semestre = Semestre;
    }
    
    public String getUsername() {
        return  Username;
    }
    
    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
