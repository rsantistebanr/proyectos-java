/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author ROBERT
 */
public class beans_stock {
    private int id_stock;
    private int id_producto;
    private int movimiento;
    private int cantidad;
    private Date fecha;
    private int estado;

    public beans_stock(int id_stock, int id_producto, int movimiento, int cantidad, Date fecha, int estado) {
        this.id_stock = id_stock;
        this.id_producto = id_producto;
        this.movimiento = movimiento;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public beans_stock() {
    }
    
    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
