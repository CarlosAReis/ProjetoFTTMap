/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import jxl.write.DateTime;

/**
 *
 * @author jojok
 */
public class Aula {
    
    private Sala Sala;
    private Professor Professor;
    private Disciplina Disciplina;
    private Curso Curso;
    private Semestre Semestre;
    private DateTime Horario;

    public Sala getSala() {
        return Sala;
    }

    public void setSala(Sala Sala) {
        this.Sala = Sala;
    }

    public Professor getProfessor() {
        return Professor;
    }

    public void setProfessor(Professor Professor) {
        this.Professor = Professor;
    }

    public Disciplina getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(Disciplina Disciplina) {
        this.Disciplina = Disciplina;
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

    public DateTime getHorario() {
        return Horario;
    }

    public void setHorario(DateTime Horario) {
        this.Horario = Horario;
    }
    
}
