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
public enum Category {
    
    COMUM("Comum"),
    ADMINISTRADOR("Admin");
    
    String Description;
    
    Category(String Description){
        this.Description = Description;
    }
    
    public String getDescription(){
        return this.Description;
    }
}
