/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.beans_stock;
import Config.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROBERT
 */
public class DAO_stock {

    connection con;
    Connection cnx;
    private PreparedStatement pst;
    private ResultSet rst;

    beans_stock b_stock;

    public DAO_stock() throws SQLException {
        con = new connection();
    }

    public List<beans_stock> Buscar_Stock_Todos() throws SQLException {
        List<beans_stock> lista = new ArrayList<>();
        String sql = "call stock_s_todos";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery(sql);

            while (rst.next()) {

                beans_stock b_stock = new beans_stock();
                b_stock.setId_stock(rst.getInt(1));
                b_stock.setId_producto(rst.getInt(2));
                b_stock.setMovimiento(rst.getInt(3));
                b_stock.setCantidad(rst.getInt(4));
                b_stock.setFecha(Date.valueOf(rst.getString(5)));
                b_stock.setEstado(rst.getInt(6));
                lista.add(b_stock);
            }

            pst.close();
            rst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public List Buscar_Stock_Codigo(int cod) throws SQLException {
        String sql = "call tienda.stock_s_codigo(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cod);
            rst = pst.executeQuery();

            List<beans_stock> lista = new ArrayList<>();
            while (rst.next()) {
                b_stock.setId_stock(rst.getInt(1));
                b_stock.setId_producto(rst.getInt(2));
                b_stock.setMovimiento(rst.getInt(3));
                b_stock.setCantidad(rst.getInt(4));
                b_stock.setFecha(Date.valueOf(rst.getString(5)));
                b_stock.setEstado(rst.getInt(6));
                lista.add(b_stock);

                lista.add(b_stock);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }

    public List Buscar_Stock_Codigo_Producto(int id_producto) throws SQLException {
        String sql = "call tienda.stock_s_producto(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_producto);
            rst = pst.executeQuery();

            List<beans_stock> lista = new ArrayList<>();
            int i = 1;
            while (rst.next()) {
                
                b_stock = new beans_stock();
                b_stock.setId_stock(rst.getInt(1));
                b_stock.setId_producto(rst.getInt(2));
                b_stock.setMovimiento(rst.getInt(3));
                b_stock.setCantidad(rst.getInt(4));
                b_stock.setFecha(Date.valueOf(rst.getString(5)));
                b_stock.setEstado(rst.getInt(6));
                lista.add(b_stock);
                i++;
                
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }

    public void InsertarStock(beans_stock s) throws SQLException {
        String sql = "call stock_i (?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, s.getId_stock());
            pst.setInt(2, s.getId_producto());
            pst.setInt(3, s.getMovimiento());
            pst.setInt(4, s.getCantidad());
             java.util.Date utilDate = s.getFecha();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            pst.setDate(5, sqlDate);
            pst.setInt(6, s.getEstado());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public int Contar_Stock() throws SQLException {
        int t = 0;
        String sql = "call stock_contar";
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
    
    public void Elimnar_Stock_Logico(int codigo) throws SQLException{
    
        String sql = "call tienda.stock_u_eliminado_logico(?)";
        
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

}
