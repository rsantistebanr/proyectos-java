/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.beans_categoria;
import Beans.beans_precio;
import Beans.beans_producto;
import Beans.beans_producto_precio_stock;
import Beans.beans_stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ROBERT
 */
public class DAO_producto_precio_stock {

    List<beans_producto> productos;
    List<beans_precio> precios;
    List<beans_categoria> categorias;
    List<beans_stock> stocks;
    List<beans_producto_precio_stock> listaProductoView;
    beans_producto_precio_stock b_PRS;

//    public DAO_producto_precio_stock() {
//        this.productos = new ArrayList<>();
//        this.categorias = new ArrayList<>();
//        this.precios = new ArrayList<>();
//        this.stocks = new ArrayList<>();
//    }
    public DAO_producto_precio_stock() {
    }

    public DAO_producto_precio_stock(List<beans_producto> productos, List<beans_precio> precios, List<beans_categoria> categorias, List<beans_stock> stocks) {
        this.productos = productos;
        this.precios = precios;
        this.categorias = categorias;
        this.stocks = stocks;
        listaProductoView = new ArrayList<>();
    }

    public List productosView() {
        int t = productos.size();
        int s = stocks.size();
        int p = precios.size();
        //JOptionPane.showMessageDialog(null, "S: " + s + " p " + p);
        int i = 0;
        while (i < t) {
            b_PRS = new beans_producto_precio_stock();
            b_PRS.setId_producto(productos.get(i).getId_producto());
            b_PRS.setNombre_producto(productos.get(i).getNombre_producto());
            b_PRS.setNombre_categoria(categorias.get(productos.get(i).getId_categoria() - 1).getNombre_categoria());
            b_PRS.setDescripcion_producto(productos.get(i).getDescripcion_producto());
            b_PRS.setPrecio(precios.get(productos.get(i).getId_precio() - 1).getPrecio_venta());
            //b_PRS.setStock(stocks.get(productos.get(i).getId_stock() - 1).getCantidad());
            b_PRS.setStock(100);
            b_PRS.setImg_producto(productos.get(i).getImg_producto());
            b_PRS.setEliminado_producto(productos.get(i).getEliminado_producto());
            
            listaProductoView.add(b_PRS);
            i++;
        }
        return listaProductoView;

    }

    public List updateStock() {

        return null;
    }
}
