/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Beans.beans_cliente;
import DAO.DAO_cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ROBERT
 */
public class T_login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
        DAO_cliente o1 = new DAO_cliente();
        List<beans_cliente> lista = new ArrayList<>();
        lista = o1.BuscarCliente_Usuario_Password("robert", "123");
        int t = lista.size();
        JOptionPane.showMessageDialog(null, "t: " + t);

      
    } catch (Exception e) {
        System.out.println("Hubo error: " + e);
    }
    }
    
}
