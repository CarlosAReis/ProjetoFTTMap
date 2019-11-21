/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author jojok
 */
public class Curso extends Entity {
    
    private String Name;
    private String Sigla;
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getInitials() {
        return Sigla;
    }

    public void setInitials(String Initials) {
        this.Sigla = Initials;
    }
}
