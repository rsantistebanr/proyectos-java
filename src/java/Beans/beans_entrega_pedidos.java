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
public class beans_entrega_pedidos {

    int id_entrega;
    int id_venta;
    int id_cliente;
    String razon_social;
    String departamento;
    String direccion;
    String referencia_lugar;
    String nombre_opcional;
    String apellidos_opcional;
    String dni_opcional;
    String telefono_opcional;
    String referencia_opcional;
    int estado_entrega;

    public beans_entrega_pedidos(int id_entrega, int id_venta, int id_cliente, String razon_social, String departamento, String direccion, String referencia_lugar, String nombre_opcional, String apellidos_opcional, String dni_opcional, String telefono_opcional, String referencia_opcional, int estado_entrega) {
        this.id_entrega = id_entrega;
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.razon_social = razon_social;
        this.departamento = departamento;
        this.direccion = direccion;
        this.referencia_lugar = referencia_lugar;
        this.nombre_opcional = nombre_opcional;
        this.apellidos_opcional = apellidos_opcional;
        this.dni_opcional = dni_opcional;
        this.telefono_opcional = telefono_opcional;
        this.referencia_opcional = referencia_opcional;
        this.estado_entrega = estado_entrega;
    }

    public beans_entrega_pedidos() {
    }

    public int getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
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

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia_lugar() {
        return referencia_lugar;
    }

    public void setReferencia_lugar(String referencia_lugar) {
        this.referencia_lugar = referencia_lugar;
    }

    public String getNombre_opcional() {
        return nombre_opcional;
    }

    public void setNombre_opcional(String nombre_opcional) {
        this.nombre_opcional = nombre_opcional;
    }

    public String getApellidos_opcional() {
        return apellidos_opcional;
    }

    public void setApellidos_opcional(String apellidos_opcional) {
        this.apellidos_opcional = apellidos_opcional;
    }

    public String getDni_opcional() {
        return dni_opcional;
    }

    public void setDni_opcional(String dni_opcional) {
        this.dni_opcional = dni_opcional;
    }

    public String getTelefono_opcional() {
        return telefono_opcional;
    }

    public void setTelefono_opcional(String telefono_opcional) {
        this.telefono_opcional = telefono_opcional;
    }

    public String getReferencia_opcional() {
        return referencia_opcional;
    }

    public void setReferencia_opcional(String referencia_opcional) {
        this.referencia_opcional = referencia_opcional;
    }

    public int getEstado_entrega() {
        return estado_entrega;
    }

    public void setEstado_entrega(int estado_entrega) {
        this.estado_entrega = estado_entrega;
    }
    
    
    
}
