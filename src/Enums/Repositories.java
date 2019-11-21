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
public enum Repositories {
    
    MYSQL("MySQL"),

    EXCEL("Excel");
 
    String description;
 
    Repositories(String description) {
        this.description = description;
    }
 
    public String getDescription() {
        return description;
    }
}
