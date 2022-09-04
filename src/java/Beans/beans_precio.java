package Beans;

import java.sql.Date;

public class beans_precio {

    private int id_precio;
    private int id_producto;
    private float precio_venta;
    private float precio_compra ;
    private Date fecha ;
    private int eliminado_precio ;


    public beans_precio(int id_precio, int id_producto, float precio_venta, float precio_compra, Date fecha, int eliminado_precio) {
        this.id_precio = id_precio;
        this.id_producto = id_producto;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.fecha = fecha;
        this.eliminado_precio = eliminado_precio;
    }

    public beans_precio() {
    }
    
    

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEliminado_precio() {
        return eliminado_precio;
    }

    public void setEliminado_precio(int eliminado_precio) {
        this.eliminado_precio = eliminado_precio;
    }

    
    
    
    
    
}
