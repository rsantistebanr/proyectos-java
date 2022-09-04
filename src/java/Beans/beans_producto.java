 package Beans;

public class beans_producto {

    private int id_producto;
    private String nombre_categoria;
    private int id_categoria;
    private String nombre_producto;
    private int id_stock;
    private int id_precio;
    private String descripcion_producto;
    private String img_producto;
    private int eliminado_producto;

    public beans_producto() {
    }

    public beans_producto(int id_producto, String nombre_categoria, int id_categoria, String nombre_producto, int id_stock, int id_precio, String descripcion_producto, String img_producto, int eliminado_producto) {
        this.id_producto = id_producto;
        this.nombre_categoria = nombre_categoria;
        this.id_categoria = id_categoria;
        this.nombre_producto = nombre_producto;
        this.id_stock = id_stock;
        this.id_precio = id_precio;
        this.descripcion_producto = descripcion_producto;
        this.img_producto = img_producto;
        this.eliminado_producto = eliminado_producto;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getEliminado_producto() {
        return eliminado_producto;
    }

    public void setEliminado_producto(int eliminado_producto) {
        this.eliminado_producto = eliminado_producto;
    }

    public String getImg_producto() {
        return img_producto;
    }

    public void setImg_producto(String img_producto) {
        this.img_producto = img_producto;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

}
