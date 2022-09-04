package DAO;

import Beans.beans_usuario;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_usuario {

    connection con;
    Connection cnx;
    beans_usuario b_usuario;
    private PreparedStatement pst;
    private ResultSet rst;

    public DAO_usuario() throws SQLException {
        this.con = new connection();

    }
    public List Buscar_Usuarios_Todos() throws SQLException {
        List<beans_usuario> lista = new ArrayList<>();
        String sql = "call tienda.usuario_s_todos";

        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery(sql);

            while (rst.next()) {
                beans_usuario b_usuario = new beans_usuario();

                b_usuario.setId_usuario(rst.getInt(1));
                b_usuario.setId_cargo(Integer.parseInt(rst.getString(2)));
                b_usuario.setUsuario(rst.getString(3));
                b_usuario.setPassword_u(rst.getString(4));
                b_usuario.setNombre(rst.getString(5));
                b_usuario.setAp_usuario(rst.getString(6));
                b_usuario.setAm_usuario(rst.getString(7));
                b_usuario.setEmail_usuario(rst.getString(8));
                b_usuario.setEliminado_usuario(rst.getInt(9));

                lista.add(b_usuario);

            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }

    }

    public List Buscar_Usuario_Password(String user, String pass) throws SQLException {
        List<beans_usuario> lista = new ArrayList<>();
        String sql = "call tienda.usuario_s_userpass(?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            
            pst.setString(1,user);
            pst.setString(2,pass);
            
            
            rst = pst.executeQuery();

            while (rst.next()) {
                beans_usuario b_usuario = new beans_usuario();
                b_usuario.setId_usuario(rst.getInt(1));
                b_usuario.setId_cargo(rst.getInt(2));
                b_usuario.setUsuario(rst.getString(3));
                b_usuario.setPassword_u(rst.getString(4));
                b_usuario.setNombre(rst.getString(5));
                b_usuario.setAp_usuario(rst.getString(6));
                b_usuario.setAm_usuario(rst.getString(7));
                b_usuario.setEmail_usuario(rst.getString(8));
                b_usuario.setEliminado_usuario(rst.getInt(9));

                lista.add(b_usuario);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {

            throw e;

        }

    }
    
    public int Contar_Usuario() throws SQLException {
        int t = 0;
        String sql = "call usuario_contar";
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
    //-----------------
    public void EliminarUsuarioCodigo(int codigo) throws SQLException {
        String sql = "call usuario_u_eliminado_logico(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    public void ModificarUsuario(beans_usuario u) throws SQLException {
        String sql = "call usuario_u_codigo(?,?,?,?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, u.getId_usuario());
            pst.setInt(2, u.getId_cargo());
            pst.setString(3, u.getUsuario());
            pst.setString(4, u.getPassword_u());
            pst.setString(5, u.getNombre());
            pst.setString(6, u.getAp_usuario());
            pst.setString(7, u.getAm_usuario());
            pst.setString(8, u.getEmail_usuario());
            pst.setInt(9, u.getEliminado_usuario());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    public void InsertarUsuario(beans_usuario u) throws SQLException {
        String sql = "call usuario_i (?,?,?,?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, u.getId_usuario());
            pst.setInt(2, u.getId_cargo());
            pst.setString(3, u.getUsuario());
            pst.setString(4, u.getPassword_u());
            pst.setString(5, u.getNombre());
            pst.setString(6, u.getAp_usuario());
            pst.setString(7, u.getAm_usuario());
            pst.setString(8, u.getEmail_usuario());
            pst.setInt(9, u.getEliminado_usuario());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarUsuarioCodigo(int codigo) throws SQLException {
        String sql = "call usuario_s_codigo(?)";

        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();

            List<beans_usuario> lista = new ArrayList<>();
            while (rst.next()) {
                b_usuario = new beans_usuario();
                b_usuario.setId_usuario(rst.getInt(1));
                b_usuario.setId_cargo(rst.getInt(2));
                b_usuario.setUsuario(rst.getString(3));
                b_usuario.setPassword_u(rst.getString(4));
                b_usuario.setNombre(rst.getString(5));
                b_usuario.setAp_usuario(rst.getString(6));
                b_usuario.setAm_usuario(rst.getString(7));
                b_usuario.setEmail_usuario(rst.getString(8));
                b_usuario.setEliminado_usuario(rst.getInt(9));
                lista.add(b_usuario);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List Filtrar_Usuario_Nombre(String patron) throws SQLException {
        String sql = "call tienda.usuario_f_nombre(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patron);
            rst = pst.executeQuery();

            List<beans_usuario> lista = new ArrayList<>();
            while (rst.next()) {
                beans_usuario b_usuario = new beans_usuario();
                b_usuario.setId_usuario(rst.getInt(1));
                b_usuario.setId_cargo(rst.getInt(2));
                b_usuario.setUsuario(rst.getString(3));
                b_usuario.setPassword_u(rst.getString(4));
                b_usuario.setNombre(rst.getString(5));
                b_usuario.setAp_usuario(rst.getString(6));
                b_usuario.setAm_usuario(rst.getString(7));
                b_usuario.setEmail_usuario(rst.getString(8));
                b_usuario.setEliminado_usuario(rst.getInt(9));
                lista.add(b_usuario);
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
