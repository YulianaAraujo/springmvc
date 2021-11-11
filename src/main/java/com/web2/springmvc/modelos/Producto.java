/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web2.springmvc.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yulis Araujo
 */

@Entity
public class Producto {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private Long id;
    private String prodNombre; 
    private String prodDesc;
    private String prodImagen;
    private Double prodPrecio;
    
    public Producto() {
    }
    
    public Producto(Long id, String prodNombre, String prodDesc, String prodImagen, Double prodPrecio){
       this.id = id;
       this.prodNombre = prodNombre;
       this.prodDesc = prodDesc;
       this.prodImagen = prodImagen;
       this.prodPrecio = prodPrecio;
    }

    public Long getId() {
        return id;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public String getProdImagen() {
        return prodImagen;
    }

    public Double getProdPrecio() {
        return prodPrecio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public void setProdImagen(String prodImagen) {
        this.prodImagen = prodImagen;
    }

    public void setProdPrecio(Double prodPrecio) {
        this.prodPrecio = prodPrecio;
    }
  
}
