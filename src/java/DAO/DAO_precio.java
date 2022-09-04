package DAO;

import Beans.beans_precio;
import Config.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_precio {

    connection con;
    Connection cnx;
    private PreparedStatement pst;
    private ResultSet rst;

    beans_precio b_precio;

    public DAO_precio() throws SQLException {
        con = new connection();
    }

    public List<beans_precio> Buscar_Precio_Todos() throws SQLException {
        List<beans_precio> lista = new ArrayList<>();
               // JOptionPane.showMessageDialog(null, "ENTRAMOS: ");

        String sql = "call precio_s_todos";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery(sql);

            while (rst.next()) {   
               // JOptionPane.showMessageDialog(null, "N de lineas: "+rst.getRow());
                beans_precio b_precio = new beans_precio();
                b_precio.setId_precio(rst.getInt(1));
                b_precio.setId_producto(rst.getInt(2));
                b_precio.setPrecio_venta(rst.getFloat(3));
                b_precio.setPrecio_compra(rst.getFloat(4));
                b_precio.setFecha(Date.valueOf(rst.getString(5)));
                b_precio.setEliminado_precio(rst.getInt(6));
                lista.add(b_precio);
            }

            pst.close();
            rst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public List Buscar_Precio_Codigo(int cod) throws SQLException {
        String sql = "call tienda.precio_s_codigo(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cod);
            rst = pst.executeQuery();

            List<beans_precio> lista = new ArrayList<>();
            while (rst.next()) {
                beans_precio b_precio = new beans_precio();
                b_precio.setId_precio(rst.getInt(1));
                b_precio.setId_producto(rst.getInt(2));
                b_precio.setPrecio_venta(rst.getFloat(3));
                b_precio.setPrecio_compra(rst.getFloat(4));
                b_precio.setFecha(rst.getDate(5));
                b_precio.setEliminado_precio(rst.getInt(6));

                lista.add(b_precio);
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
