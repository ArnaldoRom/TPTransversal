
package AccesoADatos;

import Dominio.Alumno;
import Dominio.Inscripcion;
import Dominio.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {

    private Connection conex = null;
    private MateriaData materiaD = new MateriaData();
    private AlumnoData alumnoD = new AlumnoData();
    
    
    public InscripcionData(){
        conex = Conexion.conectar();
    }
    
    public void guardarInscripcion(Inscripcion inscrip){
        String sql ="INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?,?,?)";        
        
        try {            
            PreparedStatement guardar = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            guardar.setDouble(1,inscrip.getNota());
            guardar.setInt(2, inscrip.getIdAlumno().getIdAlumno());
            guardar.setInt(3, inscrip.getIdMateria().getIdMateria());            
            guardar.executeUpdate();
            ResultSet rs = guardar.getGeneratedKeys();
            
            if(rs.next()){
                inscrip.setIdInscripto(rs.getInt("idInscripto"));
            }            
            guardar.close();            
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Error al conectar con Inscripcion", sql, 0);
        }   
    }  
    
    public List<Inscripcion> obtenerInscripciones(){
        String sql = "SELECT * FROM inscripcion JOIN materia  ON (inscripcion.idMateria = materia.idMateria) JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno) WHERE materia.estado > 0 AND alumno.estado > 0";
        List<Inscripcion> listaObtenida = new ArrayList<>();    
    
        try {            
            PreparedStatement list = conex.prepareStatement(sql);
            ResultSet obl = list.executeQuery();
            
            while(obl.next()){                
                Inscripcion obt = new Inscripcion();
                obt.setIdInscripto(obl.getInt("idInscripto"));
                obt.setNota(obl.getDouble("nota"));
                
                int idAlumno = obl.getInt("idAlumno"); 
                Alumno alumno = alumnoD.buscarAlumnoPorID(idAlumno); 
                obt.setIdAlumno(alumno);
                
                int idMateria = obl.getInt("idMateria");
                Materia materia = materiaD.buscarMateria(idMateria);
                obt.setIdMateria(materia);
           
                listaObtenida.add(obt);                
            }            
        }catch (SQLException ex) {            
           JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Incripcion");
        }   
        return listaObtenida;
    }    
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ? ";
        List<Inscripcion> inscripcionPorAlumno = new ArrayList<>();    
    
        try {
            PreparedStatement obt = conex.prepareStatement(sql);
            obt.setInt(1, idAlumno);        
            ResultSet rs = obt.executeQuery();
        
            while (rs.next()) {
                Inscripcion newIns = new Inscripcion();
                newIns.setIdInscripto(rs.getInt("idInscripto"));
                newIns.setNota(rs.getDouble("nota"));
            
                int idAlumnoo = rs.getInt("idAlumno");
                Alumno alumno = alumnoD.buscarAlumnoPorID(idAlumnoo);
                newIns.setIdAlumno(alumno);           
            
                int idMateria = rs.getInt("idMateria");
                Materia materia = materiaD.buscarMateria(idMateria);
                newIns.setIdMateria(materia);     
            
                inscripcionPorAlumno.add(newIns);
            }        
        }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectar con Inscripcion.");
        }    
        return inscripcionPorAlumno;
    }
    
    public void eliminarInscripcionMateriAlumno(int idAlumno, int idMateria) {
        String sql = "UPDATE inscripcion SET estado = 0 WHERE idAlumno = ? AND idMateria = ?";     
    
        try {
            PreparedStatement actualizar = conex.prepareStatement(sql);
            actualizar.setInt(1, idAlumno);
            actualizar.setInt(2, idMateria);        
            int verificar = actualizar.executeUpdate();  
            
            if (verificar > 0) {
               JOptionPane.showMessageDialog(null,"Inscripcion eliminada");
            } else {
               JOptionPane.showMessageDialog(null,"No se encontro ninguna inscripcion activa");
            }
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la tabla insripcion.");
        }
    }    
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";     
    
        try {            
            PreparedStatement actualizar = conex.prepareStatement(sql);           
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        String sql = "SELECT idAlumno FROM inscripcion WHERE idMateria = ?";
        List<Alumno> alumnosXMateria = new ArrayList<>();   
    
        try {
            PreparedStatement obt = conex.prepareStatement(sql);
            obt.setInt(1, idMateria);
            ResultSet rs = obt.executeQuery();
        
            while (rs.next()){
                int idAlumno = rs.getInt("idAlumno");           
                Alumno alumno = alumnoD.buscarAlumnoPorID(idAlumno); 
                if (alumno != null){
                   alumnosXMateria.add(alumno);
                }
            }
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al conectar aacon inscripcion");
        }        
        return alumnosXMateria;
    }  
}
