package DAO;

import Beans.beans_cliente;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_cliente {

    connection con;
    Connection cnx;
    beans_cliente b_cliente;
    private PreparedStatement pst;
    private ResultSet rst;

    public DAO_cliente() throws SQLException {
        this.con = new connection();
    }

    public void InsertarCliente(beans_cliente c) throws SQLException {
        String sql = "call cliente_i(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, c.getId_cliente());
            pst.setString(2, c.getUsuario_cliente());
            pst.setString(3, c.getPassword_cliente());
            pst.setString(4, c.getNombre_cliente());
            pst.setString(5, c.getAp_cliente());
            pst.setString(6, c.getAm_cliente());
            pst.setString(7, c.getTipo_documento());
            pst.setString(8, c.getNumero_documento());
            pst.setString(9, c.getSexo_cliente());
            pst.setString(10, c.getDireccion_cliente());
            pst.setString(11, c.getTelefono_cliente());
            pst.setString(12, c.getEmail_cliente());
            pst.setInt(13, c.getEliminado_cliente());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarClientesTodos() throws SQLException {
        String sql = "call client_s_todos";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();

            List<beans_cliente> lista = new ArrayList<>();
            while (rst.next()) {
                b_cliente = new beans_cliente();
                b_cliente.setId_cliente(rst.getInt(1));
                b_cliente.setUsuario_cliente(rst.getString(2));
                b_cliente.setPassword_cliente(rst.getString(3));
                b_cliente.setNombre_cliente(rst.getString(4));
                b_cliente.setAp_cliente(rst.getString(5));
                b_cliente.setAm_cliente(rst.getString(6));
                b_cliente.setTipo_documento(rst.getString(7));
                b_cliente.setNumero_documento(rst.getString(8));
                b_cliente.setSexo_cliente(rst.getString(9));
                b_cliente.setDireccion_cliente(rst.getString(10));
                b_cliente.setTelefono_cliente(rst.getString(11));
                b_cliente.setEmail_cliente(rst.getString(12));
                b_cliente.setEliminado_cliente(rst.getInt(13));
                lista.add(b_cliente);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarClienteNombre(String nombre) throws SQLException {
        String sql = "call cliente_s_nombre(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, nombre);
            rst = pst.executeQuery();

            List<beans_cliente> lista = new ArrayList<>();
            while (rst.next()) {
                b_cliente = new beans_cliente();
                b_cliente.setId_cliente(rst.getInt(1));
                b_cliente.setUsuario_cliente(rst.getString(2));
                b_cliente.setPassword_cliente(rst.getString(3));
                b_cliente.setNombre_cliente(rst.getString(4));
                b_cliente.setAp_cliente(rst.getString(5));
                b_cliente.setAm_cliente(rst.getString(6));
                b_cliente.setTipo_documento(rst.getString(7));
                b_cliente.setNumero_documento(rst.getString(8));
                b_cliente.setSexo_cliente(rst.getString(9));
                b_cliente.setDireccion_cliente(rst.getString(10));
                b_cliente.setTelefono_cliente(rst.getString(11));
                b_cliente.setEmail_cliente(rst.getString(12));
                b_cliente.setEliminado_cliente(rst.getInt(13));
                lista.add(b_cliente);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarClienteNumeroDocumento(String num_documento) throws SQLException {
        String sql = "call cliente_s_numeroDocumento(?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, num_documento);
            rst = pst.executeQuery();

            List<beans_cliente> lista = new ArrayList<>();
            while (rst.next()) {
                b_cliente = new beans_cliente();
                b_cliente.setId_cliente(rst.getInt(1));
                b_cliente.setUsuario_cliente(rst.getString(2));
                b_cliente.setPassword_cliente(rst.getString(3));
                b_cliente.setNombre_cliente(rst.getString(4));
                b_cliente.setAp_cliente(rst.getString(5));
                b_cliente.setAm_cliente(rst.getString(6));
                b_cliente.setTipo_documento(rst.getString(7));
                b_cliente.setNumero_documento(rst.getString(8));
                b_cliente.setSexo_cliente(rst.getString(9));
                b_cliente.setDireccion_cliente(rst.getString(10));
                b_cliente.setTelefono_cliente(rst.getString(11));
                b_cliente.setEmail_cliente(rst.getString(12));
                b_cliente.setEliminado_cliente(rst.getInt(13));
                lista.add(b_cliente);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void ModificarCliente(beans_cliente c) throws SQLException {
        String sql = "call cliente_u_codigo(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setInt(1, c.getId_cliente());
            pst.setString(2, c.getUsuario_cliente());
            pst.setString(3, c.getPassword_cliente());
            pst.setString(4, c.getNombre_cliente());
            pst.setString(5, c.getAp_cliente());
            pst.setString(6, c.getAm_cliente());
            pst.setString(7, c.getTipo_documento());
            pst.setString(8, c.getNumero_documento());
            pst.setString(9, c.getSexo_cliente());
            pst.setString(10, c.getDireccion_cliente());
            pst.setString(11, c.getTelefono_cliente());
            pst.setString(12, c.getEmail_cliente());
            pst.setInt(13, c.getEliminado_cliente());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void EliminarClienteCodigo(int id_cliente) throws SQLException {
        String sql = "call cliente_u_eliminado_logico";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_cliente);
            //rst = pst.executeQuery();
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List BuscarCliente_Usuario_Password(String user, String pass) throws SQLException {
        List<beans_cliente> lista = new ArrayList<>();
        String sql = "call tienda.cliente_s_userpass(?,?)";
        try {
            cnx = con.getConnection();
            pst = cnx.prepareStatement(sql);

            pst.setString(1, user);
            pst.setString(2, pass);
            rst = pst.executeQuery();

            while (rst.next()) {
                b_cliente = new beans_cliente();
                b_cliente.setId_cliente(rst.getInt(1));
                b_cliente.setUsuario_cliente(rst.getString(2));
                b_cliente.setPassword_cliente(rst.getString(3));
                b_cliente.setNombre_cliente(rst.getString(4));
                b_cliente.setAp_cliente(rst.getString(5));
                b_cliente.setAm_cliente(rst.getString(6));
                b_cliente.setTipo_documento(rst.getString(7));
                b_cliente.setNumero_documento(rst.getString(8));
                b_cliente.setSexo_cliente(rst.getString(9));
                b_cliente.setDireccion_cliente(rst.getString(10));
                b_cliente.setTelefono_cliente(rst.getString(11));
                b_cliente.setEmail_cliente(rst.getString(12));
                b_cliente.setEliminado_cliente(rst.getInt(13));
                lista.add(b_cliente);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {

            throw e;

        }

    }

    public int Contar_Clientes() throws SQLException{
        int t = 0;
        String sql = "call cliente_contar";
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
