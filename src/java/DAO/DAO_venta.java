package DAO;

import Beans.beans_venta;
import Config.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_venta {

    connection con;
    Connection cnx;
    beans_venta b_venta;
    private PreparedStatement pst;
    private ResultSet rst;

    public DAO_venta() throws SQLException {
        this.con = new connection();
    }

    public void InsertarVenta(beans_venta v) throws SQLException {
        String sql = "call venta_i(?,?,?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, v.getId_venta());
            pst.setInt(2, v.getId_cliente());
            pst.setInt(3, v.getId_usuario_venta());
            pst.setString(4, v.getTipo_comprobante_venta());
            pst.setString(5, v.getSerie_comprobante());
            pst.setString(6, v.getNumero_comprobante_venta());

            java.util.Date utilDate = v.getFecha_venta();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            //JOptionPane.showMessageDialog(null, "sql: "+sqlDate);

            pst.setDate(7, sqlDate);
            //JOptionPane.showMessageDialog(null, "sql2: "+sqlDate);
            pst.setFloat(8, v.getTotal_venta());

            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

//    public void ModificarVenta(beans_venta v) throws SQLException {
//        String sql = "call venta_u_codigo(?,?,?,?,?,?,?,?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//
//            pst.setInt(1, v.getId_venta());
//            pst.setInt(2, v.getId_cliente());
//            pst.setInt(3, v.getId_usuario_venta());
//            pst.setString(4, v.getTipo_comprobante_venta());
//            pst.setString(5, v.getSerie_comprobante());
//            pst.setString(6, v.getNumero_comprobante_venta());
//            pst.setDate(7, v.getFecha_venta());
//            pst.setFloat(8, v.getTotal_venta());
//
//            pst.executeUpdate();
//            pst.close();
//            cnx.close();
//        } catch (SQLException e) {
//            throw e;
//        }
//    }

//    public List BuscarVentaTodos() throws SQLException {
//        String sql = "call venta_s_todos";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            rst = pst.executeQuery();
//
//            List<beans_venta> lista = new ArrayList<>();
//            while (rst.next()) {
//                b_venta = new beans_venta();
//                b_venta.setId_venta(rst.getInt(1));
//                b_venta.setId_cliente(rst.getInt(2));
//                b_venta.setId_usuario_venta(rst.getInt(3));
//                b_venta.setTipo_comprobante_venta(rst.getString(4));
//                b_venta.setSerie_comprobante(rst.getString(5));
//                b_venta.setNumero_comprobante_venta(rst.getString(6));
//                b_venta.setFecha_venta(rst.getDate(7));
//                b_venta.setTotal_venta(rst.getFloat(8));
//                lista.add(b_venta);
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
//
    public List BuscarVentaCodigo_cliente(int id_cliente) throws SQLException {
        String sql = "call venta_s_codigo_cliente(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_cliente);
            rst = pst.executeQuery();

            List<beans_venta> lista = new ArrayList<>();
            while (rst.next()) {
                b_venta = new beans_venta();
                b_venta.setId_venta(rst.getInt(1));
                b_venta.setId_cliente(rst.getInt(2));
                b_venta.setId_usuario_venta(rst.getInt(3));
                b_venta.setTipo_comprobante_venta(rst.getString(4));
                b_venta.setSerie_comprobante(rst.getString(5));
                b_venta.setNumero_comprobante_venta(rst.getString(6));
                b_venta.setFecha_venta(rst.getDate(7));
                b_venta.setTotal_venta(rst.getFloat(8));
                lista.add(b_venta);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }
        public List BuscarVentaCodigo(int id_venta) throws SQLException {
        String sql = "call venta_s_codigo_cliente(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_venta);
            rst = pst.executeQuery();

            List<beans_venta> lista = new ArrayList<>();
            while (rst.next()) {
                b_venta = new beans_venta();
                b_venta.setId_venta(rst.getInt(1));
                b_venta.setId_cliente(rst.getInt(2));
                b_venta.setId_usuario_venta(rst.getInt(3));
                b_venta.setTipo_comprobante_venta(rst.getString(4));
                b_venta.setSerie_comprobante(rst.getString(5));
                b_venta.setNumero_comprobante_venta(rst.getString(6));
                b_venta.setFecha_venta(rst.getDate(7));
                b_venta.setTotal_venta(rst.getFloat(8));
                lista.add(b_venta);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }
//
//    public List BuscarVentaNumeroeroComprobante(String num_comprobante) throws SQLException {
//        String sql = "call venta_s_numComprobante(?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            pst.setString(1, num_comprobante);
//            rst = pst.executeQuery();
//
//            List<beans_venta> lista = new ArrayList<>();
//            while (rst.next()) {
//                b_venta = new beans_venta();
//                b_venta.setId_venta(rst.getInt(1));
//                b_venta.setId_cliente(rst.getInt(2));
//                b_venta.setId_usuario_venta(rst.getInt(3));
//                b_venta.setTipo_comprobante_venta(rst.getString(4));
//                b_venta.setSerie_comprobante(rst.getString(5));
//                b_venta.setNumero_comprobante_venta(rst.getString(6));
//                b_venta.setFecha_venta(rst.getDate(7));
//                b_venta.setTotal_venta(rst.getFloat(8));
//                lista.add(b_venta);
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
//
//    public List BuscarVentaFecha(Date fecha) throws SQLException {
//        String sql = "call venta_s_fecha(?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            pst.setDate(1, fecha);
//            rst = pst.executeQuery();
//
//            List<beans_venta> lista = new ArrayList<>();
//            while (rst.next()) {
//                b_venta = new beans_venta();
//                b_venta.setId_venta(rst.getInt(1));
//                b_venta.setId_cliente(rst.getInt(2));
//                b_venta.setId_usuario_venta(rst.getInt(3));
//                b_venta.setTipo_comprobante_venta(rst.getString(4));
//                b_venta.setSerie_comprobante(rst.getString(5));
//                b_venta.setNumero_comprobante_venta(rst.getString(6));
//                b_venta.setFecha_venta(rst.getDate(7));
//                b_venta.setTotal_venta(rst.getFloat(8));
//                lista.add(b_venta);
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//        } catch (SQLException e) {
//            throw e;
//        }
//    }

    public int Contar_Venta() throws SQLException {
        int t = 0;
        String sql = "call venta_contar";
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
