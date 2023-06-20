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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VALENTINA
 */
public class Bolsillo {
    private String nombreBolsillo;
    private double saldo;
    private double meta;
    
    Bases con1 = new Bases();
    private Connection conexion;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    java.sql.Connection cx;

    
    public Bolsillo(String nombreBolsillo, double saldo, double meta){
        this.nombreBolsillo = nombreBolsillo;
        this.saldo = saldo;
        this.meta = meta;
    }
    
    public Bolsillo(){}
    
     /**
     * @return the nombreBolsillo
     */
    public String getNombreBolsillo() {
        return nombreBolsillo;
    }

    /**
     * @param nombreBolsillo the nombreBolsillo to set
     */
    public void setNombreBolsillo(String nombreBolsillo) {
        this.nombreBolsillo = nombreBolsillo;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the meta
     */
    public double getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(double meta) {
        this.meta = meta;
    }
    
    public boolean crearBolsillo(int idUsuario, String nombreBolsillo, double saldoInicial, double meta){
        
        try {
            String saldoStr = String.valueOf(saldoInicial);
            String metaStr = String.valueOf(meta);
            

             if (nombreBolsillo.equals("") || saldoStr.equals("") || metaStr.equals("")) {
                 
                return false;
                
            } else {
                String sql = "INSERT INTO bolsillo (id_usuario, NombreBolsillo, saldoDisponible, Meta) VALUES ('" + idUsuario + "', '" + nombreBolsillo + "', '" + saldoInicial + "', '" + meta + "' )";
                String query = "UPDATE usuario SET SaldoInicial = SaldoInicial - " + saldoInicial + " WHERE id = '" + idUsuario + "'";
                conexion = con1.conectar();
                st = conexion.createStatement();
                st.executeUpdate(sql);
                st.executeUpdate(query);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        
        return true;
    }
    
    public ResultSet retornarBolsillos(int idUsuario){
        
        try {
            String sql = "SELECT * FROM bolsillo WHERE id_usuario = " + idUsuario;

            conexion = con1.conectar();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }
    
    public boolean verificarNombreBolsillo(String nombreBolsillo){
       
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        
        try {
        
            Statement statement = conexion.createStatement();
            String query = "SELECT * FROM bolsillo WHERE nombreBolsillo = '" + nombreBolsillo + "'";
            ResultSet resultSet = statement.executeQuery(query);
            
            return resultSet.next();
            
    }   catch (SQLException ex) {
            Logger.getLogger(MostrarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
    }
    
    public int consignarDineroBolsillo(String nombreBolsillo, String celular, double saldo){
        
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE bolsillo SET SaldoDisponible = SaldoDisponible + " + saldo + " WHERE NombreBolsillo = '" + nombreBolsillo + "'";
            String query2 = "UPDATE usuario SET SaldoInicial = SaldoInicial - " + saldo + " WHERE Celular = '" + celular + "'";

            int filasActualizadas1 = statement.executeUpdate(query);
            int filasActualizadas2 = statement.executeUpdate(query2);
            
            filasActualizadas = filasActualizadas1 + filasActualizadas2;
            
            
            return filasActualizadas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
        
    }
    
    public int retirarDineroBolsillo(String nombreBolsillo, String celular, double saldo){
        
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE bolsillo SET SaldoDisponible = SaldoDisponible - " + saldo + " WHERE NombreBolsillo = '" + nombreBolsillo + "'";
            String query2 = "UPDATE usuario SET SaldoInicial = SaldoInicial + " + saldo + " WHERE Celular = '" + celular + "'";

            int filasActualizadas1 = statement.executeUpdate(query);
            int filasActualizadas2 = statement.executeUpdate(query2);
            
            filasActualizadas = filasActualizadas1 + filasActualizadas2;
            
            
            return filasActualizadas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
        
    }
    
    public int eliminarBolsillo(String nombreBolsillo){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasAfectadas = 0;
        
         try {
            Statement statement = conexion.createStatement();
            String query = "DELETE FROM bolsillo WHERE NombreBolsillo = '" + nombreBolsillo+ "'";
            filasAfectadas = statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return filasAfectadas;
    }
    
    
}

   

