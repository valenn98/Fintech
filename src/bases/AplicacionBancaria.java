/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author VALENTINA
 */
class AplicacionBancaria {

    public AplicacionBancaria() {}
    
    
    public int consignarDinero(String celular, double saldo){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE usuario SET SaldoInicial = SaldoInicial + " + saldo + " WHERE Celular = '" + celular + "'";
            filasActualizadas = statement.executeUpdate(query);
            
            return filasActualizadas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
        
    }
    
    public int retirarDinero(String celular, double saldo){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE usuario SET SaldoInicial = SaldoInicial - " + saldo + " WHERE Celular = '" + celular + "'";
            filasActualizadas = statement.executeUpdate(query);
            
            return filasActualizadas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
        
    }
    
    public boolean verificarDatosDestinatario(String celular){
       
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        
        try {
        
            Statement statement = conexion.createStatement();
            String query = "SELECT * FROM usuario WHERE Celular = '" + celular +"'";
            ResultSet resultSet = statement.executeQuery(query);
            
            return resultSet.next();
            
    }   catch (SQLException ex) {
            Logger.getLogger(MostrarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
    }
    
    public int transferirDinero(String celular, String destinatario, double saldo){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE usuario SET SaldoInicial = SaldoInicial - " + saldo + " WHERE Celular = '" + celular + "'";
            String query2 = "UPDATE usuario SET SaldoInicial = SaldoInicial + " + saldo + " WHERE Celular = '" + destinatario + "'";

            int filasActualizadasQuery1 = statement.executeUpdate(query);
            int filasActualizadasQuery2 = statement.executeUpdate(query2);

            filasActualizadas = filasActualizadasQuery1 + filasActualizadasQuery2;
            
            
            return filasActualizadas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
        
    }

    


}