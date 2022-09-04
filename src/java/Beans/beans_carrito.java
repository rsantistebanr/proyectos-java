
package Beans;

public class beans_carrito {
    private int item ;
    private int id_venta;
    private int id_producto;
    private String nombre;
    private String descripcion;
    private String img_producto;
    private int cantidad;
    private float precio_venta;
    private float subtotal;

    public beans_carrito(int item, int id_venta, int id_producto, String nombre, String descripcion, String img_producto, int cantidad, float precio_venta, float subtotal) {
        this.item = item;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img_producto = img_producto;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.subtotal = subtotal;
    }

    public beans_carrito() {
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
