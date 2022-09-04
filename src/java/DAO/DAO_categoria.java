package DAO;

import Beans.*;
import Config.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_categoria {

    connection cn;
    Connection cnx;
    beans_categoria beans_categoria;
    private PreparedStatement pst;
    private ResultSet rst;

    public DAO_categoria() throws SQLException {
        this.cn = new connection();
    }

    public List BuscarCategoriaTodos() throws SQLException {
        String sql = "call categoria_s_todos";
        
        try {
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();
            List<beans_categoria> lista = new ArrayList<>();
            while (rst.next()) {
                beans_categoria = new beans_categoria();
                beans_categoria.setId_categoria(rst.getInt(1));
                beans_categoria.setNombre_categoria(rst.getString(2));
                beans_categoria.setDescripcion(rst.getString(3));
                beans_categoria.setEliminado_categoria(rst.getInt(4));
                lista.add(beans_categoria);
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
//    public List BuscarCategoriaNombre(String nombre) throws SQLException {
//        String sql = "call categoria_s_sigla(?)";
//        try {
//            con = con.getConexion();
//            pst = con.prepareStatement(sql);
//            pst.setString(1, sigla);
//            rst = pst.executeQuery();
//
//            List<beans_categoria> lista = new ArrayList<>();
//            while (rst.next()) {
//                b_categoria = new beans_categoria();
//                b_categoria.setCodigo_categoria(rst.getInt(1));
//                b_categoria.setSigla_categoria(rst.getString(2));
//                b_categoria.setNombre_categoria(rst.getString(3));
//                b_categoria.setEliminado_categoria(rst.getInt(4));
//                lista.add(b_categoria);
//            }
//            pst.close();
//            rst.close();
//            con.close();
//            return lista;
//
//        } catch (SQLException e) {
//            throw e;
//        }
//    }

    public void InsertarCategoria(beans_categoria c) throws SQLException {
        try {
            String sql = "call tienda.categoria_i(?,?,?,?)";
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_categoria());
            pst.setString(2, c.getNombre_categoria());
            pst.setString(3, c.getDescripcion());
            pst.setInt(4, c.getEliminado_categoria());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }
    }
//

    public void ModificarCategoria_Codigo(beans_categoria c) throws SQLException {
        try {
            String sql = "call tienda.categoira_u_codigo(?,?,?,?)";
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, c.getId_categoria());
            pst.setString(2, c.getNombre_categoria());
            pst.setString(3, c.getDescripcion());
            pst.setInt(4, c.getEliminado_categoria());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        } catch (SQLException e) {
            throw e;
        }

    }

    public List BuscarCategoriaCodigo(int cod) throws SQLException {
        String sql = "call tienda.categoria_s_codigo(?)";
        try {
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, cod);
            rst = pst.executeQuery();

            List<beans_categoria> lista = new ArrayList<>();
            while (rst.next()) {
                beans_categoria b_categoria = new beans_categoria();
                b_categoria.setId_categoria(rst.getInt(1));
                b_categoria.setNombre_categoria(rst.getString(2));
                b_categoria.setDescripcion(rst.getString(3));
                b_categoria.setEliminado_categoria(rst.getInt(4));
                lista.add(b_categoria);
            }
            pst.close();
            rst.close();
            cnx.close();
            return lista;

        } catch (SQLException e) {
            throw e;
        }
    }

    public int ContarCategorias() throws SQLException {
        int t = 0;
        String sql = "call categoria_contar";
        try {
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            rst = pst.executeQuery();

            if (rst.next()) {//devuelve una fila con un unico valor
                t = rst.getInt(1);
            }
            pst.close();
            rst.close();
            cn.close();
        } catch (SQLException e) {
            throw e;
        }
        return t;
    }

    public void Eliminado_Categoria_Logico(int codigo) throws SQLException {

        String sql = "call categoria_u_eliminado_logico(?)";

        try {
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, codigo);

            pst.executeUpdate();

            pst.close();
            cnx.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List Filtrar_Categoria_Nombre(String patron) throws SQLException {
        String sql = "call tienda.categoria_f_nombre(?)";
        try {
            cnx = cn.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patron);
            rst = pst.executeQuery();

            List<beans_categoria> lista = new ArrayList<>();
            while (rst.next()) {
                beans_categoria b_categoria = new beans_categoria();
                b_categoria.setId_categoria(rst.getInt(1));
                b_categoria.setNombre_categoria(rst.getString(2));
                b_categoria.setDescripcion(rst.getString(3));
                b_categoria.setEliminado_categoria(rst.getInt(4));

                lista.add(b_categoria);
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
