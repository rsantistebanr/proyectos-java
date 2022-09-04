package DAO;

import Beans.beans_proveedor;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_proveedor {

    connection con;
    Connection cnx;
    beans_proveedor b_proveedor;
    private PreparedStatement pst;
    private ResultSet rst;

    public DAO_proveedor() throws SQLException {
        this.con = new connection();
    }

    public void InsertarProveedor(beans_proveedor p) throws SQLException {
        String sql = "call proveedor_i (?,?,?.?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, p.getId_proveedor());
            pst.setString(2, p.getRuc());
            pst.setString(3, p.getNombre_proveedor());
            pst.setInt(4, p.getEstado_proveedor());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarProveedorTodos() throws SQLException {
        String sql = "call proveedor_s_todos";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();

            List<beans_proveedor> lista = new ArrayList<>();
            while (rst.next()) {
                b_proveedor = new beans_proveedor();
                b_proveedor.setId_proveedor(rst.getInt(1));
                b_proveedor.setRuc(rst.getString(2));
                b_proveedor.setNombre_proveedor(rst.getString(3));
                b_proveedor.setEstado_proveedor(rst.getInt(4));
                lista.add(b_proveedor);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarProveedorCodigo(int codigo) throws SQLException {
        String sql = "call proveedor_s_codigo(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();

            List<beans_proveedor> lista = new ArrayList<>();
            while (rst.next()) {
                b_proveedor = new beans_proveedor();
                b_proveedor.setId_proveedor(rst.getInt(1));
                b_proveedor.setRuc(rst.getString(2));
                b_proveedor.setNombre_proveedor(rst.getString(3));
                b_proveedor.setEstado_proveedor(rst.getInt(4));
                lista.add(b_proveedor);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarProveedorRuc(String ruc) throws SQLException {
        String sql = "call proveedor_s_ruc(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, ruc);
            rst = pst.executeQuery();

            List<beans_proveedor> lista = new ArrayList<>();
            while (rst.next()) {
                b_proveedor = new beans_proveedor();
                b_proveedor.setId_proveedor(rst.getInt(1));
                b_proveedor.setRuc(rst.getString(2));
                b_proveedor.setNombre_proveedor(rst.getString(3));
                b_proveedor.setEstado_proveedor(rst.getInt(4));
                lista.add(b_proveedor);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }

    }

    public void ModificarProveedorCodigo(beans_proveedor p) throws SQLException {
        String sql = "call proveedor_u_codigo(?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            
            pst.setInt(1, p.getId_proveedor());
            pst.setString(2, p.getRuc());
            pst.setString(3, p.getNombre_proveedor());
            pst.setInt(4, p.getEstado_proveedor());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
             throw e;
        }
    }
    
    public void EliminarProveedorCodigo(int id_proveedor) throws SQLException {
        String sql = "call proveedor_u_eliminado_logico";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_proveedor);
            rst = pst.executeQuery();
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
