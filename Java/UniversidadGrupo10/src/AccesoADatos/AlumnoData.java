
package AccesoADatos;

import Dominio.Alumno;
import java.sql.*;
import java.time.LocalDate;
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
    
    
    public Alumno buscarAlumnoPorDni(int dni){
    
        String sql = "SELECT dni, apellido, nombre, fechaDeNacimiento, estado FROM alumno WHERE dni = ? ";
        Alumno obtenerAlumno = null;
        
        try {
            
            PreparedStatement buscar = conex.prepareStatement(sql);
            buscar.setInt(1, dni);
            
            ResultSet lista = buscar.executeQuery();
            
            while(lista.next()){
            
                String apellido = lista.getString("apellido");
                String nombre = lista.getString("nombre");
                LocalDate fecha = lista.getDate("fechaDeNacimiento").toLocalDate();
                boolean estado = lista.getBoolean("estado");
                
                obtenerAlumno = new Alumno (dni, apellido, nombre, fecha, estado);
            
            } 
            
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el alumno");
        }
        
        
        return obtenerAlumno;
        
    }
    
   
    public void actualizarDatosAlumno(Alumno alumno){
    
        String sql = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaDeNacimiento=? WHERE idAlumno = ? OR dni = ?";
        try {
            
            PreparedStatement update = conex.prepareStatement(sql);
            update.setInt(1, alumno.getDni());
            update.setString(2, alumno.getApellido());
            update.setString(3, alumno.getNombre());
            update.setDate(4, Date.valueOf(alumno.getFechaDeNacimiento()));
            update.setInt(5, alumno.getIdAlumno());        
            update.setInt(6, alumno.getDni());
            update.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos.");
        }
    
    }
    
    
    
    
    public void modificarEstado(int dni){
    
        String sql = "UPDATE alumno SET estado = 0 WHERE dni = ?";
        
        
        try {
            
            PreparedStatement modificar = conex.prepareStatement(sql);
            modificar.setInt(1, dni);
            
            modificar.executeUpdate();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al modificar estado");
        }
        
    
    }
    
    
    public void habilitarEstado(int dni){
        String sql = "UPDATE alumno SET estado = 1 WHERE dni = ?";
        
        try {
            
            PreparedStatement estado = conex.prepareStatement(sql);
            estado.setInt(1, dni);
            estado.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el Estado");
        }
    
    }
    
    
    
    public void eliminarAlumno(int id){
        
        String sql = "DELETE FROM alumno JOIN inscripcion ON (alumno.idAumno = inscripcion.idAlumno) WHERE idAlumno = ?";
        PreparedStatement borrar;
        
        try {
            
            borrar = conex.prepareStatement(sql);
            borrar.setInt(1, id);
            borrar.executeUpdate();
           
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al eliminar el alumno. ");
        }
        
 
    }
    
    
    
    
    
}
