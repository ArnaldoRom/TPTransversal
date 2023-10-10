
package AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String BD="universidadgrupo10";
    private static final String USUARIO="root";
    private static final String CONTRASENA="";
    private static Connection conexion;
    
    public Conexion(){        
        
    }
    
    public static Connection conectar(){
        
        if(conexion == null){
        
        try {
            // TODO code application logic here

            Class.forName("org.mariadb.jdbc.Driver");
            conexion=DriverManager.getConnection(URL+BD,USUARIO,CONTRASENA);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error carga de Driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de Conexion");
        }
        
    }
        return conexion;
        }
    
}
