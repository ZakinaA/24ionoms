/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author matys
 */

public class Vehicules {
    private int id;
    private String immat;
    private Date dateOrigin;
    private Date dateRevision;
    private Caserne uneCaserne;
    
    public Vehicules(){}
    
    public Vehicules(int id){
        this.id = id;
    }
    
    public Vehicules(int id, String immat){
        this.id = id;
        this.immat = immat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public Date getDateOrigin() {
        return dateOrigin;
    }

    public void setDateOrigin(Date dateOrigin) {
        this.dateOrigin = dateOrigin;
    }

    public Date getDateRevision() {
        return dateRevision;
    }

    public void setDateRevision(Date dateRevision) {
        this.dateRevision = dateRevision;
    }

    public Caserne getUneCaserne() {
        return uneCaserne;
    }

    public void setUneCaserne(Caserne uneCaserne) {
        this.uneCaserne = uneCaserne;
    }
}
