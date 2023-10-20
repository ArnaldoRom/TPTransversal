
package AccesoADatos;

import Dominio.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            
            PreparedStatement carga = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            carga.setInt(1,alumno.getDni());
            carga.setString(2, alumno.getApellido());
            carga.setString(3, alumno.getNombre());
            carga.setDate(4,Date.valueOf(alumno.getFechaDeNacimiento()));
            carga.setBoolean(5, alumno.isEstado());
            
            carga.executeUpdate();
            
            ResultSet rs = carga.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito!");
            }
            
            carga.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumno");
        }
        
    
    }
    
    
   public Alumno buscarAlumnoPorID(int idAlumno) {
    String sql = "SELECT dni, apellido, nombre, fechaDeNacimiento, estado FROM alumno WHERE idAlumno = ? AND estado = 1";
    Alumno obtenerAlumno = null;
    
    try {
        PreparedStatement buscar = conex.prepareStatement(sql);
        buscar.setInt(1, idAlumno);
        
        ResultSet lista = buscar.executeQuery();
        
        while (lista.next()) {
            int dni = lista.getInt("dni");
            String apellido = lista.getString("apellido");
            String nombre = lista.getString("nombre");
            LocalDate fecha = lista.getDate("fechaDeNacimiento").toLocalDate();
            boolean estado = lista.getBoolean("estado");
            
            obtenerAlumno = new Alumno(idAlumno, dni, apellido, nombre, fecha, estado);
        } 
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar el alumno");
    }
    
    return obtenerAlumno;
}
    
   public Alumno buscarAlumnoPorDNI(int dni) {
    String sql = "SELECT dni, apellido, nombre, fechaDeNacimiento, estado FROM alumno WHERE dni = ? AND estado = 1";
    Alumno obtenerAlumno = null;
    
    try {
        PreparedStatement buscar = conex.prepareStatement(sql);
        buscar.setInt(1, dni);
        
        ResultSet lista = buscar.executeQuery();
        
        while (lista.next()) {
            int dnii = lista.getInt("dni");
            String apellido = lista.getString("apellido");
            String nombre = lista.getString("nombre");
            LocalDate fecha = lista.getDate("fechaDeNacimiento").toLocalDate();
            boolean estado = lista.getBoolean("estado");
            
            obtenerAlumno = new Alumno( dnii, apellido, nombre, fecha, estado);
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
    
    
    
    public void desabilitarEstado(int id){
    
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        
        
        
        try {
            
            PreparedStatement modificar = conex.prepareStatement(sql);
            modificar.setInt(1, id);
            
            modificar.executeUpdate();
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al modificar estado");
        }
        
        
    }
    
    
    public void habilitarEstado(int id){
        String sql = "UPDATE alumno SET estado = 1 WHERE idAlumno = ?";
        
        try {
            
            PreparedStatement estado = conex.prepareStatement(sql);
            estado.setInt(1, id);
            estado.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el Estado");
        }
    
    }
    
    
    
   
    
    public List<Alumno> listarAlumnos(){
     
        List<Alumno> listaAlumno = new ArrayList<>();
        
        
        try {
            
            String sql = "SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement lista = conex.prepareStatement(sql);
            ResultSet lista2 = lista.executeQuery();
            
            while (lista2.next()){
               Alumno alumno = new Alumno();
               alumno.setIdAlumno(lista2.getInt("idAlumno"));
               alumno.setDni(lista2.getInt("dni"));
               alumno.setApellido(lista2.getString("apellido"));
               alumno.setNombre(lista2.getString("nombre"));
               alumno.setFechaDeNacimiento(lista2.getDate("fechaDeNacimiento").toLocalDate());
               alumno.setEstado(lista2.getBoolean("estado"));
                
               listaAlumno.add(alumno);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los alumnos.");
        }
        
        return listaAlumno;
    }
    
    
    
}
