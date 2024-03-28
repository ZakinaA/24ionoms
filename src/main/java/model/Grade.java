/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ts1sio
 */
public class Grade {
    private int id;
    private String libelle;
    private SurGrade grade;
    
    public Grade(){
        
    }
    
    public Grade(int id, String libelle, SurGrade grade){
        this.id = id;
        this.libelle = libelle;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public SurGrade getSurGrade() {
        return grade;
    }

    public void setSurGrade(SurGrade grade) {
        this.grade = grade;
    }
}
