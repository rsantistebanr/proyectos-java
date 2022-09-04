package Beans;

public class beans_detalle_venta {

     int id_detalle_venta;
    int id_venta;
    int id_producto;
    int cantidad_producto;
    float precio_venta;
    float subtotal;

    public beans_detalle_venta() {
    }

    public beans_detalle_venta(int id_detalle_venta, int id_venta, int id_producto, int cantidad_producto, float precio_venta, float subtotal) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_venta = precio_venta;
        this.subtotal = subtotal;
    }
    

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    
    
}
