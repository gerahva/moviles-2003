/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.humbert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

/**
 *
 * @author humbe
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Perfil {
    
    @Id
    private String id;
    
    private String nombre;
    private String paterno;
    private String mail;
    private String celular;
    private int edad;

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", mail=" + mail + ", celular=" + celular + ", edad=" + edad + '}';
    }

  

    public Perfil() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
