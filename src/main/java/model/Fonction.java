/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author matys
 */

public class Fonction {
    private int id;
    private String libelle;
    private ArrayList<Pompier> lesPompiers;
    
    public Fonction(){}
    
    public Fonction(int code){
        this.id = code;
    }
    
    public Fonction(int code, String libelle){
        this.id = code;
        this.libelle = libelle;
    }

    public int getCode() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCode(int code) {
        this.id = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }

    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }
    
    public void addPompier(Pompier p){
        if (lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(p);
    }
}
