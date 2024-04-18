/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class SurGrade {
    private int id;
    private String libelle;
    private ArrayList<Grade> grades;
    
    public SurGrade(){
        
    }
    
    public SurGrade(int id, String libelle){
        this.id = id;
        this.libelle = libelle;
    }
    
    public SurGrade(int id, String libelle, ArrayList<Grade> grades){
        this.id = id;
        this.libelle = libelle;
        this.grades = grades;
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

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
    
    public void addGrade(Grade grade) {
        if(grades == null){
            grades = new ArrayList<Grade>();
        }
        
        for(Grade g : grades){
            if(grade.getId() == g.getId()){
                System.out.println("ERREUR : Un grade possèdant le même Id est déjà existant ! (ID : " + g.getId() + ")");
                return;
            }
        }
        
        grades.add(grade);
    }
}
