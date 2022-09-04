/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author ROBERT
 */
public class beans_producto_precio_stock {
    private int id_producto;
    private String nombre_categoria;
    private String nombre_producto;
    private int stock;
    private float precio;
    private String descripcion_producto;
    private String img_producto;
    private int eliminado_producto;

    public beans_producto_precio_stock(int id_producto, String nombre_categoria, String nombre_producto, int stock, float precio, String descripcion_producto, String img_producto, int eliminado_producto) {
        this.id_producto = id_producto;
        this.nombre_categoria = nombre_categoria;
        this.nombre_producto = nombre_producto;
        this.stock = stock;
        this.precio = precio;
        this.descripcion_producto = descripcion_producto;
        this.img_producto = img_producto;
        this.eliminado_producto = eliminado_producto;
    }

    public beans_producto_precio_stock() {
    }
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public int getEliminado_producto() {
        return eliminado_producto;
    }

    public void setEliminado_producto(int eliminado_producto) {
        this.eliminado_producto = eliminado_producto;
    }
    
    
}
