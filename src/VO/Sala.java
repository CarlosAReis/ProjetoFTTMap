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
public class Sala extends Entity {
    
    private String Nome;
    private Bloco Bloco;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Bloco getBloco() {
        return Bloco;
    }

    public void setBloco(Bloco Bloco) {
        this.Bloco = Bloco;
    }
    
}
