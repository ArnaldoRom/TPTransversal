
package AccesoADatos;

import Dominio.Alumno;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {
    private Connection conex;
    
    public AlumnoData(){
        conex = Conexion.conectar();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaDeNacimiento, estado) "
                + "  VALUES  (?,?,?,?,?) ";
        
        try {
            
            PreparedStatement carga = conex.prepareStatement(sql);
            
            carga.setInt(1,alumno.getDni());
            carga.setString(2, alumno.getApellido());
            carga.setString(3, alumno.getNombre());
            carga.setDate(4,Date.valueOf(alumno.getFechaDeNacimiento()));
            carga.setBoolean(5, alumno.isEstado());
            
            carga.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumno");
        }
        
    
    }
    
}
