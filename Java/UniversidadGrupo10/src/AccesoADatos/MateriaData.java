
package AccesoADatos;

import Dominio.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
            PreparedStatement guardar = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//Investicar Return Generated Keys
            guardar.setString(1,materia.getNombre());
            guardar.setInt(2, materia.getAnio());
            guardar.setBoolean(3, true);            
            guardar.executeUpdate();           
            ResultSet rs = guardar.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                JOptionPane.showMessageDialog(null,"Materia Añadida");
            }            
            guardar.close();            
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
               JOptionPane.showMessageDialog(null,"Materia no encontrada");
          }
            buscar.close();
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
            int modificar=modi.executeUpdate();
            if(modificar==1){
                JOptionPane.showMessageDialog(null,"Materia modificada");
            }
            modi.close();
        } catch (SQLException ex) {            
           JOptionPane.showMessageDialog(null, "Error de conexion");            
        }        
    }
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET estado = false WHERE idMateria = ?";
        
        try {           
            PreparedStatement eliminar = conex.prepareStatement(sql);
            eliminar.setInt(1, id);
            int aliminado=eliminar.executeUpdate();
            if(aliminado==1){
                JOptionPane.showMessageDialog(null,"Materia Eliminada");
            }
            eliminar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }       
    }
    
    public List<Materia> listarMaterias(){    
        String sql = "SELECT * FROM materia WHERE estado = 1";      
        List<Materia> listado;
        listado = new ArrayList<>();
        
        try {            
            PreparedStatement listar = conex.prepareStatement(sql);            
            ResultSet list = listar.executeQuery();
            
            while(list.next()){
                Materia materia = new Materia();
                materia.setIdMateria(list.getInt("idMateria"));
                materia.setNombre(list.getString("nombre"));
                materia.setAnio(list.getInt("anio"));
                listado.add(materia); 
            }
            listar.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conecectar con la tabla Materia");
        }       
        return listado;
    }   
}
