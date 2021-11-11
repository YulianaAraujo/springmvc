/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web2.springmvc.controladores;

import com.web2.springmvc.repositorio.RepositorioProducto;
import com.web2.springmvc.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Yulis Araujo
 */
@RestController
public class ProductoControlador {
    
    @Autowired
    RepositorioProducto repositorioProducto;
    
    @RequestMapping("/producto")
    public String producto (Model modelo) {
        modelo.addAttribute("productos", repositorioProducto.findAll());
        return "producto";
    }
    
    @RequestMapping("/crear")
    public String crear (Model modelo){
        return "crear";
    }
    
    @RequestMapping("/guardar")
    public String guardar (@RequestParam String prodNombre, @RequestParam String prodDesc, @RequestParam String prodImagen, 
            @RequestParam Double prodPrecio){
        Producto producto = new Producto();
        producto.setProdNombre(prodNombre);
        producto.setProdDesc(prodDesc);
        producto.setProdImagen(prodImagen);
        producto.setProdPrecio(prodPrecio);
        repositorioProducto.save(producto);
        
        return "redirect:/mostrar/" + producto.getId();
    }
    
    @RequestMapping("/mostrar/{id}")
    public String mostrar (@PathVariable Long id, Model model){
        model.addAttribute("producto", repositorioProducto.findById(id).orElse(null));
        return "mostrar";
    }
    
    @RequestMapping("/borrar")
    public String borrar (@RequestParam Long id){
        Producto producto = repositorioProducto.findById(id).orElse(null);
        repositorioProducto.delete(producto);
        
        return "redirect:/producto";
    }
    
    @RequestMapping("/modificar")
    public String modificar (@RequestParam Long id, @RequestParam String prodNombre, @RequestParam String prodDesc, 
            @RequestParam Double prodPrecio, @RequestParam String prodImagen){
        Producto producto =  repositorioProducto.findById(id).orElse(null);
        producto.setProdNombre(prodNombre);
        producto.setProdDesc(prodDesc);
        producto.setProdImagen(prodImagen);
        producto.setProdPrecio(prodPrecio);
        repositorioProducto.save(producto);
        
        return "redirect:/mostrar/" + producto.getId();
    }
}
