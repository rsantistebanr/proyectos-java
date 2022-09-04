/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

public class beans_venta {

    private int id_venta;
    private int id_cliente;
    private int id_usuario_venta;
    private String tipo_comprobante_venta;
    private String serie_comprobante;
    private String numero_comprobante_venta;
    private Date fecha_venta;
    private float total_venta;

    public beans_venta() {
    }

    public beans_venta(int id_venta, int id_cliente, int id_usuario_venta, String tipo_comprobante_venta, String serie_comprobante, String num_comprobante_venta, Date fecha_venta, float total_venta) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_usuario_venta = id_usuario_venta;
        this.tipo_comprobante_venta = tipo_comprobante_venta;
        this.serie_comprobante = serie_comprobante;
        this.numero_comprobante_venta = num_comprobante_venta;
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
    }
    
    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario_venta() {
        return id_usuario_venta;
    }

    public void setId_usuario_venta(int id_usuario_venta) {
        this.id_usuario_venta = id_usuario_venta;
    }

    public String getTipo_comprobante_venta() {
        return tipo_comprobante_venta;
    }

    public void setTipo_comprobante_venta(String tipo_comprobante_venta) {
        this.tipo_comprobante_venta = tipo_comprobante_venta;
    }

    public String getSerie_comprobante() {
        return serie_comprobante;
    }

    public void setSerie_comprobante(String serie_comprobante) {
        this.serie_comprobante = serie_comprobante;
    }

    public String getNumero_comprobante_venta() {
        return numero_comprobante_venta;
    }

    public void setNumero_comprobante_venta(String numero_comprobante_venta) {
        this.numero_comprobante_venta = numero_comprobante_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public float getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(float total_venta) {
        this.total_venta = total_venta;
    }
    
    

}
