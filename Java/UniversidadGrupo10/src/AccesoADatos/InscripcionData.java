
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
            
            PreparedStatement guardar = conex.prepareStatement(sql);
            
            guardar.setDouble(1,inscrip.getNota());
            guardar.setInt(2, inscrip.getIdAlumno().getIdAlumno());
            guardar.setInt(3, inscrip.getIdMateria().getIdMateria());
            
            
            guardar.executeUpdate();
            
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar con Inscripcion", sql, 0);
        }
        
        
    
    }
    
    public List<Inscripcion> obtenerInscripciones(){
    String sql = "SELECT * FROM inscripcion";
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
            
        } catch (SQLException ex) {
            
           JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Incripcion");
        }
    
    
        return listaObtenida;
    }
}
