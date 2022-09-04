package DAO;

import Beans.beans_carrito;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_carrito {

    private ResultSet rst;
    private Connection cnx;
    private PreparedStatement pst;

    beans_carrito b_carrito;
    connection con;

    public DAO_carrito() throws SQLException {
        this.con = new connection();
    }

    public void Insertar_Carrito(beans_carrito c) throws SQLException {
        try {
            String sql = "call tienda.carrito_i(?,?,?,?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getItem());
            pst.setInt(2, c.getId_venta());
            pst.setInt(3, c.getId_producto());
            pst.setString(4, c.getNombre());
            pst.setString(5, c.getDescripcion());
            pst.setString(6, c.getImg_producto());
            pst.setInt(7, c.getCantidad());
            pst.setFloat(8, c.getPrecio_venta());
            pst.setFloat(9, c.getSubtotal());

            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
//

    public void Modificar_Carrito_item(beans_carrito c) throws SQLException {
        try {
            String sql = "call tienda.carrito_u_item(?,?,?,?,?,?,?,?,?)";
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getItem());
            pst.setInt(2, c.getId_venta());
            pst.setInt(3, c.getId_producto());
            pst.setString(4, c.getNombre());
            pst.setString(5, c.getDescripcion());
            pst.setString(6, c.getImg_producto());
            pst.setInt(7, c.getCantidad());
            pst.setFloat(8, c.getPrecio_venta());
            pst.setFloat(9, c.getSubtotal());
            pst.executeUpdate();

            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }

    }

    public List Buscar_Producto_Codigo_Venta(int cod) throws SQLException {
        String sql = "call tienda.carrito_s_codigo(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cod);
            rst = pst.executeQuery();

            List<beans_carrito> lista = new ArrayList<>();
            while (rst.next()) {
                beans_carrito b_carrito = new beans_carrito();
                b_carrito.setItem(rst.getInt(1));
                b_carrito.setId_venta(rst.getInt(2));
                b_carrito.setId_producto(rst.getInt(3));
                b_carrito.setNombre(rst.getString(4));
                b_carrito.setDescripcion(rst.getString(5));
                b_carrito.setImg_producto(rst.getString(6));
                b_carrito.setCantidad(rst.getInt(7));
                b_carrito.setPrecio_venta(rst.getFloat(8));
                b_carrito.setSubtotal(rst.getFloat(9));

                lista.add(b_carrito);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }
    
    public List Buscar_Carrito_Todos() throws SQLException {
        String sql = "call tienda.carrito_s_todos";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();

            List<beans_carrito> lista = new ArrayList<>();
            while (rst.next()) {
                beans_carrito b_carrito = new beans_carrito();
                b_carrito.setItem(rst.getInt(1));
                b_carrito.setId_venta(rst.getInt(2));
                b_carrito.setId_producto(rst.getInt(3));
                b_carrito.setNombre(rst.getString(4));
                b_carrito.setDescripcion(rst.getString(5));
                b_carrito.setImg_producto(rst.getString(6));
                b_carrito.setCantidad(rst.getInt(7));
                b_carrito.setPrecio_venta(rst.getFloat(8));
                b_carrito.setSubtotal(rst.getFloat(9));

                lista.add(b_carrito);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }
    
    
    
    public List Buscar_carrito_item(int item) throws SQLException {
        String sql = "call tienda.carrito_s_item(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, item);
            rst = pst.executeQuery();

            List<beans_carrito> lista = new ArrayList<>();
            while (rst.next()) {
                beans_carrito b_carrito = new beans_carrito();
                b_carrito.setItem(rst.getInt(1));
                b_carrito.setId_venta(rst.getInt(2));
                b_carrito.setId_producto(rst.getInt(3));
                b_carrito.setNombre(rst.getString(4));
                b_carrito.setDescripcion(rst.getString(5));
                b_carrito.setImg_producto(rst.getString(6));
                b_carrito.setCantidad(rst.getInt(7));
                b_carrito.setPrecio_venta(rst.getFloat(8));
                b_carrito.setSubtotal(rst.getFloat(9));

                lista.add(b_carrito);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }
    

    public void Delete_Producto(int item) throws SQLException {

        String sql = "call tienda.carrito_delete_codigo(?)";

        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, item);

            pst.executeUpdate();

            pst.close();
            cnx.close();

        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void Delete_Carrito(int id_cliente) throws SQLException {

        String sql = "call tienda.carrito_delete(?)";

        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_cliente);

            pst.executeUpdate();

            pst.close();
            cnx.close();

        } catch (SQLException e) {
            throw e;
        }
    }
    
    



    public int Contar_Carrito(int id_venta) throws SQLException {
        int t = 0;
        String sql = "call carrito_contar(?)";
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
    
    public int Contar_Carrito_Todos() throws SQLException {
        int t = 0;
        String sql = "call carrito_contar_todos";
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

//    public List Filtrar_Producto_Categoria_Nombre(int cateogoria, String patron) throws SQLException {
//        String sql = "call tienda.carrito_f_nombre_categoria(?,?)";
//        try {
//            cnx = con.getConnection();
//            pst = cnx.prepareStatement(sql);
//            pst.setInt(1, cateogoria);
//            pst.setString(2, patron);
//            rst = pst.executeQuery();
//
//            List<beans_carrito> lista = new ArrayList<>();
//            while (rst.next()) {
//                beans_carrito b_carrito = new beans_carrito();
//                b_carrito.setId_carrito(rst.getInt(1));
//                b_carrito.setId_categoria(rst.getInt(2));
//                b_carrito.setNombre_carrito(rst.getString(3));
//                b_carrito.setId_stock(rst.getInt(4));
//                b_carrito.setId_precio(rst.getInt(5));
//                b_carrito.setDescripcion_carrito(rst.getString(6));
//                b_carrito.setImg_carrito(rst.getString(7));
//                b_carrito.setEliminado_carrito(rst.getInt(8));
//
//                lista.add(b_carrito);
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
