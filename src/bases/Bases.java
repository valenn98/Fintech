/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bases;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VALENTINA
 */
public class Bases {
    String baseDatos = "fintech";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    java.sql.Connection cx;
    
    private static Bases instancia;

    public static Bases getInstancia() {
        if (instancia == null) {
            instancia = new Bases();
        }
        return instancia;
    }

    
    public Bases(){
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver); 
            cx = DriverManager.getConnection(url + baseDatos, user, password);
            System.out.println("Se conecto"+ baseDatos);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se conecto");
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
    Bases bases= new Bases();
    bases.conectar();
    }

    Statement getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            
            
}
