
package AccesoADatos;

import Dominio.Materia;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {
    private Connection conex = null;
    
    
    
    public MateriaData(){
       conex = Conexion.conectar();
    }
    
    public void guardarMateria(Materia materia){
         
        String sql = "INSERT  INTO materia (nombre, anio, estado)"
                + " VALUES (?,?,?)";
        
        try {
            
            
            PreparedStatement guardar = conex.prepareStatement(sql);
            guardar.setString(1,materia.getNombre());
            guardar.setInt(2, materia.getAnio());
            guardar.setBoolean(3, true);
            
            guardar.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error al guardar la Materia");
        }
        
        
    }
    
    
    
    public Materia buscarMateria(int id){
        
        String sql = "SELECT * FROM materia WHERE idMateria = ? AND estado = 1";
        Materia mat = null;
        
        try {
            
            
            PreparedStatement buscar = conex.prepareStatement(sql);
            buscar.setInt(1, id);
            ResultSet result = buscar.executeQuery();
            
          if(result.next()){
          
              
               int idd = result.getInt("idMateria");
               String nom = result.getString("nombre");
               int anio = result.getInt("anio");
               
               mat = new Materia(idd, nom, anio, true);
              
          }else{
               System.out.println("Materia no encontrada");

          }
          
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la Materia");
        }
    
        return mat;
        
    }
    
    
    
    
    public void modificarMateria(Materia materia){
    
        String sql = "UPDATE  materia SET nombre = ?, anio = ? WHERE idMateria = ?";
        
        try {
            PreparedStatement modi = conex.prepareStatement(sql);
            modi.setString(1, materia.getNombre());
            modi.setInt(2, materia.getAnio());
            modi.setInt(3, materia.getIdMateria());
            
            modi.executeUpdate();
            
        } catch (SQLException ex) {
            
           JOptionPane.showMessageDialog(null, "Error de conexion");
            
        }
        
        
        
    }
    
    
    
    
}
