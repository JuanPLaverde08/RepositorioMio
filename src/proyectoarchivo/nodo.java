/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarchivo;


public class nodo {
    
    int cedula,edad;
    String nombre;
    float nota;
    nodo liga;
    
    

    public nodo(int cedula, String nombre,int edad,float nota) {
        this.cedula = cedula;
        this.edad = edad;
        this.nombre = nombre;
        this.nota = nota;
        this.liga = null;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public nodo getLiga() {
        return liga;
    }

    public void setLiga(nodo liga) {
        this.liga = liga;
    }
}
    

