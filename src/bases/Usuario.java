/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bases;

/**
 *
 * @author VALENTINA
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Usuario {
    private String cedula;
    private String nombre;
    private String apellidos;
    private String celular;
    private String direccionElectronica;
    private int clave;
    private double saldo;

    Bases con1 = new Bases();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    java.sql.Connection cx;

    public Usuario(String cedula, String nombre, String apellidos, String celular, String direccionElectronica, double saldo, int clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.direccionElectronica = direccionElectronica;
        this.clave = clave;
        this.saldo = saldo;
    }

    public Usuario(String celular, int clave){
        this.celular = celular;
        this.clave = clave;
    }
    
    public Usuario(){}
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccionElectronica() {
        return direccionElectronica;
    }

    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }
    
    public int getClave() {
        return clave;
    }
    
    public void setClave (int clave) {
        this.clave = clave;
    }

    
    public double getSaldo() {
        return saldo;
    }

    public boolean crearUsuario(String nombre,String apellidos,String cedula, String celular, String direccionElectronica, int clave, double saldoInicial){
        
        try {
            String claveStr = Integer.toString(clave);
            String saldoStr = String.valueOf(saldoInicial);

            if (nombre.equals("") || apellidos.equals("") || cedula.equals("") || celular.equals("") || direccionElectronica.equals("") || claveStr.equals("") || saldoStr.equals("")) {
                
                return false;
             
            } else {
                
                String sql = "insert into usuario (Nombre, Apellidos, Cédula, Celular, Email, Clave, SaldoInicial) values ('"+nombre+"', '"+apellidos+"', '"+cedula+"', '"+celular+"', '"+direccionElectronica+"', '"+clave+"', '"+saldoInicial+"' )";
                conet = con1.conectar();
                st = conet.createStatement();
                st.executeUpdate(sql);
               
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
    public ResultSet retornarUsuarios(){
        
        try {
            String sql = "select * from usuario";

            conet = con1.conectar();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }
    
    public int eliminarUsuario(String celular, int clave){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasAfectadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "DELETE FROM usuario WHERE Celular = '" + celular + "' AND Clave = '" + clave+ "'";
            filasAfectadas = statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return filasAfectadas;
    }
    
    public boolean verificarDatos(String celular, int clave){
       
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        
        try {
        
            Statement statement = conexion.createStatement();
            String query = "SELECT * FROM usuario WHERE Celular = '" + celular + "' AND Clave = '" + clave + "'";
            ResultSet resultSet = statement.executeQuery(query);
            
            return resultSet.next();
            
    }   catch (SQLException ex) {
            Logger.getLogger(MostrarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            return false;
    }
    }
    
    
    public ResultSet obtenerDatos(String numero){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        
        
        try {
            Statement statement = conexion.createStatement();
            String query = "SELECT * FROM usuario WHERE Celular = '" + numero + "'";
            rs= statement.executeQuery(query);
            
            return rs;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return rs;
    }
    
    public int actualizarDatos(String nuevoCelular, String nuevoEmail, String nuevaClave, String numero){
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();
        int filasActualizadas = 0;
        
        try {
            Statement statement = conexion.createStatement();
            String query = "UPDATE usuario SET Celular = '" + nuevoCelular + "', Email = '" + nuevoEmail + "', Clave = '" + nuevaClave + "' WHERE Celular = '" + numero + "'";
            filasActualizadas = statement.executeUpdate(query);
            
            return filasActualizadas;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filasActualizadas;
    }
    
    
    public int obtenerIdUsuario(String numero) {
        Bases bases = Bases.getInstancia();
        Connection conexion = bases.conectar();

        try {
            Statement statement = conexion.createStatement();
            String query = "SELECT * FROM usuario WHERE Celular = '" + numero + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0; // O un valor que indique que no se encontró el usuario
    }
}
