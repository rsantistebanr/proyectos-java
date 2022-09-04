package DAO;

import Beans.beans_detalle_venta;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_detalle_venta {

    private ResultSet rst;
    private Connection cnx;
    private PreparedStatement pst;

    beans_detalle_venta b_detalle_venta;
    connection con;

    public DAO_detalle_venta() throws SQLException {
        this.con = new connection();
    }

    public List Buscar_detalle_venta(int id_venta) throws SQLException {
        List<beans_detalle_venta> lista = new ArrayList<>();
        String sql = "call tienda.detalle_venta_s_id_venta(?)";

        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_venta);

            rst = pst.executeQuery();

            while (rst.next()) {
                beans_detalle_venta b_detalle_venta = new beans_detalle_venta();

                b_detalle_venta.setId_detalle_venta(rst.getInt(1));
                b_detalle_venta.setId_venta(rst.getInt(2));
                b_detalle_venta.setId_producto(rst.getInt(3));
                b_detalle_venta.setCantidad_producto(rst.getInt(4));
                b_detalle_venta.setPrecio_venta(rst.getFloat(5));
                b_detalle_venta.setSubtotal(rst.getFloat(6));

                lista.add(b_detalle_venta);

            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }

    public void Insertar_Detalle_Venta(beans_detalle_venta c) throws SQLException {
        try {
            String sql = "call tienda.detalle_venta_i(?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_detalle_venta());
            pst.setInt(2, c.getId_venta());
            pst.setInt(3, c.getId_producto());
            pst.setInt(4, c.getCantidad_producto());
            pst.setFloat(5, c.getPrecio_venta());
            pst.setFloat(6, c.getSubtotal());
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int Contar_detalle_venta(int id_venta) throws SQLException {
        int t = 0;
        String sql = "call detalle_venta_contar(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_venta);

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

    public int Contar_detalle_venta_Todos() throws SQLException {
        int t = 0;
        String sql = "call detalle_venta_contar_todos";
        
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
    
    


//    public List Filtrar_Producto_Nombre(String patron) throws SQLException {
//        String sql = "call tienda.detalle_venta_f_nombre(?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            pst.setString(1, patron);
//            rst = pst.executeQuery();
//
//            List<beans_detalle_venta> lista = new ArrayList<>();
//            while (rst.next()) {
//                beans_detalle_venta b_detalle_venta = new beans_detalle_venta();
//                b_detalle_venta.setId_detalle_venta(rst.getInt(1));
//                b_detalle_venta.setId_categoria(rst.getInt(2));
//                b_detalle_venta.setNombre_detalle_venta(rst.getString(3));
//               b_detalle_venta.setId_stock(rst.getInt(4));
//                 b_detalle_venta.setId_precio(rst.getInt(5));
//                b_detalle_venta.setDescripcion_detalle_venta(rst.getString(6));
//                b_detalle_venta.setImg_detalle_venta(rst.getString(7));
//                b_detalle_venta.setEliminado_detalle_venta(rst.getInt(8));
//                
//                lista.add(b_detalle_venta);
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
//    public List Filtrar_Producto_Categoria_Nombre(int cateogoria,String patron) throws SQLException {
//        String sql = "call tienda.detalle_venta_f_nombre_categoria(?,?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            pst.setInt(1, cateogoria);
//            pst.setString(2, patron);
//            rst = pst.executeQuery();
//
//            List<beans_detalle_venta> lista = new ArrayList<>();
//            while (rst.next()) {
//                beans_detalle_venta b_detalle_venta = new beans_detalle_venta();
//                b_detalle_venta.setId_detalle_venta(rst.getInt(1));
//                b_detalle_venta.setId_categoria(rst.getInt(2));
//                b_detalle_venta.setNombre_detalle_venta(rst.getString(3));
//                b_detalle_venta.setId_stock(rst.getInt(4));
//                 b_detalle_venta.setId_precio(rst.getInt(5));
//                b_detalle_venta.setDescripcion_detalle_venta(rst.getString(6));
//                b_detalle_venta.setImg_detalle_venta(rst.getString(7));
//                b_detalle_venta.setEliminado_detalle_venta(rst.getInt(8));
//                
//                lista.add(b_detalle_venta);
//            }
//            pst.close();
//            rst.close();
//            cnx.close();
//            return lista;
//
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
}
