/*
 * To change this license header, choose License Headerst in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.beans_producto;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROBERT
 */
public class DAO_producto {

    private ResultSet rst;
    private Connection cnx;
    private PreparedStatement pst;

    beans_producto b_producto;
    connection con;

    public DAO_producto() throws SQLException {
        this.con = new connection();
    }

//    public List Buscar_Producto_Todos() throws SQLException {
//        List<beans_producto> lista = new ArrayList<>();
//        String sql = "call tienda.producto_s_todos";
//
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            rst = pst.executeQuery(sql);
//
//            while (rst.next()) {
//                beans_producto b_producto = new beans_producto();
//
//                b_producto.setId_producto(rst.getInt(1));
//                b_producto.setId_producto(rst.getInt(2));
//                b_producto.setNombre_producto(rst.getString(3));
//                b_producto.setStock(rst.getInt(4));
//                b_producto.setDescripcion_producto(rst.getString(5));
//                b_producto.setEliminado_producto(rst.getInt(6));
//
//                lista.add(b_producto);
//
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//
//        } catch (SQLException e) {
//            throw e;
//        }
//
//    }
//    public List Buscar_Producto_Todos_NC() throws SQLException {
//        List<beans_producto> lista = new ArrayList<>();
//        String sql = "call tienda.producto_s_todos_categoriaNombre()";
//
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            rst = pst.executeQuery(sql);
//
//            while (rst.next()) {
//
//                beans_producto b_producto = new beans_producto();
//
//                b_producto.setId_producto(rst.getInt(5));
//                b_producto.setNombre_producto(rst.getString(7));
//                b_producto.setNombre_categoria(rst.getString(2));
//                b_producto.setStock(rst.getInt(8));
//                b_producto.setDescripcion_producto(rst.getString(9));
//                b_producto.setEliminado_producto(rst.getInt(10));
//
//                lista.add(b_producto);
//
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//
//        } catch (SQLException e) {
//            throw e;
//        }
//
//    }

    public void Insertar_Producto(beans_producto c) throws SQLException {
        try {
            String sql = "call tienda.producto_i(?,?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_producto());
            pst.setInt(2, c.getId_categoria());
            pst.setString(3, c.getNombre_producto());
            pst.setInt(4, c.getId_stock());
            pst.setInt(5, c.getId_precio());
            pst.setString(6, c.getDescripcion_producto());
            pst.setString(7, c.getImg_producto());
            pst.setInt(8, c.getEliminado_producto());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }


    public void Modificar_Producto_Codigo(beans_producto c) throws SQLException {
        try {
            String sql = "call tienda.producto_u_codigo(?,?,?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_producto());
            pst.setInt(2, c.getId_categoria());
            pst.setString(3, c.getNombre_producto());
            pst.setInt(4, c.getId_stock());
            pst.setInt(5, c.getId_precio());
            pst.setString(6, c.getDescripcion_producto());
            pst.setString(7, c.getImg_producto());
            pst.setInt(8, c.getEliminado_producto());
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }

    }

    public List Buscar_Producto_Codigo(int cod) throws SQLException {
        String sql = "call tienda.producto_s_codigo(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cod);
            rst = pst.executeQuery();

            List<beans_producto> lista = new ArrayList<>();
            while (rst.next()) {
                beans_producto b_producto = new beans_producto();
                b_producto.setId_producto(rst.getInt(1));
                b_producto.setId_categoria(rst.getInt(2));
                b_producto.setNombre_producto(rst.getString(3));
                b_producto.setId_stock(rst.getInt(4));
                 b_producto.setId_precio(rst.getInt(5));
                b_producto.setDescripcion_producto(rst.getString(6));
                b_producto.setImg_producto(rst.getString(7));
                b_producto.setEliminado_producto(rst.getInt(8));
                lista.add(b_producto);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }
    
    public void Elimnar_Producto_Logico(int codigo) throws SQLException{
    
        String sql = "call producto_u_eliminado_logico(?)";
        
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, codigo);
            
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
            
            
        } catch (SQLException e) {
            throw e;
        }
    }

    public List Filtrar_Producto_Nombre(String patron) throws SQLException {
        String sql = "call tienda.producto_f_nombre(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patron);
            rst = pst.executeQuery();

            List<beans_producto> lista = new ArrayList<>();
            while (rst.next()) {
                beans_producto b_producto = new beans_producto();
                b_producto.setId_producto(rst.getInt(1));
                b_producto.setId_categoria(rst.getInt(2));
                b_producto.setNombre_producto(rst.getString(3));
               b_producto.setId_stock(rst.getInt(4));
                 b_producto.setId_precio(rst.getInt(5));
                b_producto.setDescripcion_producto(rst.getString(6));
                b_producto.setImg_producto(rst.getString(7));
                b_producto.setEliminado_producto(rst.getInt(8));
                
                lista.add(b_producto);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }
    }
    
    public int Contar_Producto() throws SQLException {
        int t = 0;
        String sql = "call producto_contar";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();

            if (rst.next()) {//devuelve una fila con un unico valor
                t = rst.getInt(1);
            }
            pst.close();
            rst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
        return t;
    }
    
    public List Filtrar_Producto_Categoria_Nombre(int cateogoria,String patron) throws SQLException {
        String sql = "call tienda.producto_f_nombre_categoria(?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cateogoria);
            pst.setString(2, patron);
            rst = pst.executeQuery();

            List<beans_producto> lista = new ArrayList<>();
            while (rst.next()) {
                beans_producto b_producto = new beans_producto();
                b_producto.setId_producto(rst.getInt(1));
                b_producto.setId_categoria(rst.getInt(2));
                b_producto.setNombre_producto(rst.getString(3));
                b_producto.setId_stock(rst.getInt(4));
                 b_producto.setId_precio(rst.getInt(5));
                b_producto.setDescripcion_producto(rst.getString(6));
                b_producto.setImg_producto(rst.getString(7));
                b_producto.setEliminado_producto(rst.getInt(8));
                
                lista.add(b_producto);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }
    }
}   
