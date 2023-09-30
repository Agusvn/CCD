package Conexion;

import java.sql.*;

public class ConexionDB {
    private Connection con;
    
    public Connection iniciarConexion(){
        String url = "jdbc:mysql://localhost:3306/ccd_db";
        String user = "root";
        String contr = "12341234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, contr);
            return con;
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
