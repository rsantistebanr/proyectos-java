/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.beans_entrega_pedidos;
import Beans.beans_entrega_pedidos;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ROBERT
 */
public class DAO_entrega_pedidos {

    private ResultSet rst;
    private Connection cnx;
    private PreparedStatement pst;

    beans_entrega_pedidos b_entrega_pedido;
    connection con;

    public DAO_entrega_pedidos() throws SQLException {
        this.con = new connection();
    }
    public void Insertar_Entrega_pedido(beans_entrega_pedidos c) throws SQLException {
        try {
            String sql = "call tienda.entrega_pedidos_i(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_entrega());
            pst.setInt(2, c.getId_venta());
             pst.setInt(3, c.getId_cliente());
            pst.setString(4, c.getRazon_social());
            pst.setString(5, c.getDepartamento());
            pst.setString(6, c.getDireccion());
            pst.setString(7, c.getReferencia_lugar());
            pst.setString(8, c.getNombre_opcional());
            pst.setString(9, c.getApellidos_opcional());
            pst.setString(10, c.getDni_opcional());
            pst.setString(11, c.getTelefono_opcional());
            pst.setString(12, c.getReferencia_opcional());
            pst.setInt(13, c.getEstado_entrega());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public int Contar_Entrega_Pedidos() throws SQLException {
        int t = 0;
        String sql = "call tienda.entrega_pedidos_contar";
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
}
