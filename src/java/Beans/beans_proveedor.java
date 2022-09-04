
package Beans;

public class beans_proveedor {
    private int id_proveedor;
    private String ruc;
    private String nombre_proveedor;
    private int estado_proveedor;

    
    public beans_proveedor(int id_proovedor, String ruc, String nombre_proveedor, int estado_proveedor) {
        this.id_proveedor=  estado_proveedor;
        this.ruc = ruc;
        this.nombre_proveedor = nombre_proveedor;
        this.estado_proveedor = estado_proveedor;
    }

    public beans_proveedor() {
   
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getEstado_proveedor() {
        return estado_proveedor;
    }

    public void setEstado_proveedor(int estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }

    }
    
   

