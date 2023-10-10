
package universidadgrupo10;

import AccesoADatos.AlumnoData;
import Dominio.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UniversidadGrupo10 {

   
    public static void main(String[] args) {
        
        Alumno alumno = new Alumno(40334343, "eaaaa", "Matias", LocalDate.of(2005,10,11), true);
        
        AlumnoData carga = new AlumnoData();
        carga.guardarAlumno(alumno);
        
    }
    
}
