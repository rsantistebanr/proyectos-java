/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Beans.beans_carrito;
import Beans.beans_detalle_venta;
import Beans.beans_stock;
import Beans.beans_venta;
import DAO.DAO_carrito;
import DAO.DAO_detalle_venta;
import DAO.DAO_precio;
import DAO.DAO_stock;
import DAO.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ROBERT
 */
public class T_D_Precio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        DAO_precio o1 = new DAO_precio();
//        DAO_stock o2  = new DAO_stock();
//        int t = o1.Buscar_Precio_Todos().size();
//        //int t = o2.Buscar_Stock_Todos().size();
//        System.out.println("Tamaño de lista precio: " + t);
        //System.out.println("t: "+t);

//        DAO_carrito o1 = new DAO_carrito();
//        int t = o1.Contar_Carrito(1);
        DAO_detalle_venta o3 = new DAO_detalle_venta();
//        int d_V = o3.Contar_detalle_venta(1);
//
//        System.out.println("t: " + d_V);
//        Date fecha = new Date();
//        System.out.println(fecha);
//
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        
//        beans_venta b_venta = new beans_venta(1, 1, 1, "Factura", "00000", "1111", sqlDate, 2100.0f);
//        DAO_venta d_venta2 = new DAO_venta();
//        d_venta2.InsertarVenta(b_venta);
//        
//     beans_detalle_venta b_detalle_venta = new beans_detalle_venta(1,1, 1,10,  2100.0f,2100.0f);
//        DAO_detalle_venta d_d_venta = new DAO_detalle_venta();
//        d_d_venta.Insertar_Detalle_Venta(b_detalle_venta);
//        
//        System.out.println("utilDate:" + utilDate);
//        System.out.println("sqlDate:" + sqlDate);

//    DAO_carrito dAO_carrito = new DAO_carrito();
//        List<beans_carrito> Recupero_carrito = dAO_carrito.Buscar_Producto_Codigo_Venta(1);
//        JOptionPane.showMessageDialog(null, "Recupero: " + Recupero_carrito.size());
//    }
//        DAO_venta d_venta = new DAO_venta();
//        List<beans_venta> l_ventas = d_venta.BuscarVentaCodigo_cliente(1);
//        //JOptionPane.showMessageDialog(null, "l_Ventas: " + l_ventas.size());
//        DAO_detalle_venta d_detalle_venta = new DAO_detalle_venta();
//
//        List<beans_detalle_venta> l_detalles = d_detalle_venta.Buscar_detalle_venta(10);
//        System.out.println("l_detalles: " + l_detalles.size());
        //se modifica primero al atributo id_venta(id_Cliente) y luego a la tabla
//                        beans_carrito b_carrito = new beans_carrito();
//                        b_carrito.setItem(2);
//                        b_carrito.setId_venta(1);
//                        DAO_carrito m_carrito = new DAO_carrito();
//                        m_carrito.Modificar_Carrito_item(b_carrito);
//DAO_entrega_pedidos contar_entrega_pedidos = new DAO_entrega_pedidos();
//        int num_entrega = contar_entrega_pedidos.Contar_Entrega_Pedidos()+1;
        DAO_stock d_stock = new DAO_stock();
        List<beans_stock> stock = d_stock.Buscar_Stock_Codigo_Producto(2);
        for (beans_stock s : stock) {
            System.out.println("id: " + s.getId_producto());
            System.out.println("id_s: " + s.getId_stock());
            System.out.println("cant" + s.getCantidad());

        }
        //JOptionPane.showMessageDialog(null, "Stock: size " + stock.size());

    }

}
