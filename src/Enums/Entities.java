/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author jojok
 */
public enum Entities {
    
    AULA("aula"),
        
    BLOCO("bloco"),

    CURSO("curso"),
    
    DISCIPLINA("disciplina"),
    
    PROFESSOR("professor"),
    
    SALA("sala"),
    
    SEMESTRE("semestre"),
    
    USUARIO("perfil");
    
    String Description;
    
    Entities(String Description){
        this.Description = Description;
    }
    public String getDescription(){
        return this.Description;
    }
}
